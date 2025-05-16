public class Storage extends Place{
    private String name;
    private Employee employee;
    private Product[] product_list = new Product[]{};
    public Storage(String name,Employee employee,Product[] product_list){
        this.name = name;
        this.employee = employee;
        this.product_list = product_list;
    }
    public Storage(String name,Product[] product_list){
        this.name = name;
        this.employee = null;
        this.product_list = product_list;
    }

    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void getInfo(){
        if (employee!=null) {
            System.out.println("Функция здания: Склад");
            System.out.println("Ответственный сотрудник: " + employee.getFirst_name() + " " + employee.getSecond_name());
            System.out.print("Адрес: ");
            for (int i = 5; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        }else{
            System.out.println("Функция здания: Склад");
            System.out.println("Ответственный сотрудник: нет");
            System.out.print("Адрес: ");
            for (int i = 5; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        }
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public void transport(int product_index,int amount, Place place){
        int currentAmount = product_list[product_index].getAmount();
        place.add(product_list[product_index].getName(),amount,product_list[product_index].getPrice());
        if(currentAmount==amount){
            remove(product_index);
        }else{
            product_list[product_index].setAmount(currentAmount-amount);
        }
    }

    @Override
    public void add(String name,int amount,int price){
        System.out.println(name+" added");
        boolean flag = false;
        int currentAmount;
        for (Product currentProduct: product_list){
            currentAmount=currentProduct.getAmount();
            if (currentProduct.getName().equals(name)){
                currentProduct.setAmount(currentAmount+amount);
                flag = true;
            }
        }
        if(flag==false){
            Product[] tempList = new Product[this.product_list.length+1];
            for(int i=0;i<this.product_list.length;i++){
                tempList[i] = product_list[i];
            }
            tempList[this.product_list.length] = new Product(name,amount,price);
            this.product_list = tempList;
        }
    }
    @Override
    public void remove(int index){
        int size = this.product_list.length;
        Product[] tempList = new Product[size-1];
        for (int i = 0; i<index;i++){
            tempList[i] = this.product_list[i];
        }
        for (int i = index+1; i< this.product_list.length;i++){
            tempList[i-1] = this.product_list[i];
        }
        this.product_list = tempList;
    }
    @Override
    public Product getProduct(int index){
        return product_list[index];
    }
    @Override
    public int getLength(){
        return product_list.length;
    }
}
