package org.example;

public class Employee {
    private String name;
    private Place workingPlace;

    public Employee(String name) {
        this.name = name;
    }

    public void setWorkingPlace(Place workingPlace) {
        this.workingPlace = workingPlace;
    }

    public String getName() {
        return name;
    }

    public Place getWorkingPlace() {
        return workingPlace;
    }
}
