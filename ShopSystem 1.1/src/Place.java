public abstract class Place {
    private String name;
    private Employee employee;
    private Product[] product_list;

    public abstract Employee getEmployee();
    public abstract void setEmployee(Employee employee);
    public abstract void getInfo();
    public abstract String getName();
    public abstract Product getProduct(int index);
    public abstract int getLength();

    public abstract void transport(int product_index,int amount,Place place);
    public abstract void add(String name,int amount,int price);
    public abstract void remove(int index);
}
