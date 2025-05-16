package org.example;

public abstract class Place {
    private String name;
    private Employee employee;
    private Product[] product_list;
    private String type;

    public abstract Employee getEmployee();
    public abstract void setEmployee(Employee employee);
    public abstract void getInfo();
    public abstract String getName();
    public abstract Product getProduct(int index);
    public abstract int getLength();
    public abstract String getType();

    public abstract void transport(int product_index,int amount,Place place);
    public abstract void add(String name,int amount,int price);
    public abstract void remove(int index);

}
