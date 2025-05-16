package org.example;

import java.util.ArrayList;

public class SellingPlace extends Place {
    private String name;
    private Employee employee;
    private ArrayList<Product> product_list;
    private int sellingAmount;
    private String type = "Пункт продаж";

    public SellingPlace(String name, Employee employee, ArrayList<Product> product_list) {
        this.name = name;
        this.employee = employee;
        this.product_list = product_list;
        this.sellingAmount = 0;
    }
    public SellingPlace(String name,Employee employee){
        this.name = name;
        this.employee = employee;
        this.product_list = new ArrayList<Product>();
    }
    @Override
    public void transport(int product_index,int amount, Place place){
        Product currentProduct = product_list.get(product_index);
        int currentAmount = currentProduct.getAmount();
        place.add(currentProduct.getName(),amount,currentProduct.getPrice());
        if(currentAmount==amount){
            remove(product_index);
        }else{
            this.product_list.get(product_index).setAmount(currentAmount-amount);
        }
    }

    @Override
    public void add(String name,int amount,int price){
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
            this.product_list.add(new Product(name,amount,price));
        }
    }
    @Override
    public void remove(int index){
        this.product_list.remove(index);
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
            System.out.println("Функция здания: Пункт продаж");
            System.out.println("Ответственный сотрудник: " + employee.getName());
            System.out.print("Адрес: ");
            for (int i = 5; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        }else{
            System.out.println("Функция здания: Пункт продаж");
            System.out.println("Ответственный сотрудник: нет");
            System.out.print("Адрес: ");
            for (int i = 5; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        }
        System.out.println();
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public Product getProduct(int index){
        return product_list.get(index);
    }
    @Override
    public int getLength(){
        return product_list.size();
    }

    public void Sell(int index,int amount) {
        int currentAmount = product_list.get(index).getAmount();
        if (amount == currentAmount) {
            this.product_list.remove(index);
        } else {
            this.product_list.get(index).setAmount(currentAmount - amount);
        }
    }
    public String getType(){
        return type;
    }
}
