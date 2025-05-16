package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ListingEditor {
    public static void createEmployee(DocumentListing currentListing){
        System.out.println("Введите имя нового сотрудника:");
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        currentListing.addEmployee(new Employee(input));
        new Menu(currentListing);
    }
    public static void createStorage(DocumentListing currentListing){
        boolean flag = false;
        int intInput = 0;
        Place tempPlace;
        System.out.println("Введите название нового склада:");
        Scanner sc  = new Scanner(System.in);
        String name = sc.nextLine();
        String input;
        System.out.println();
        System.out.println("Выберите ответственного сотрудника:");
        for (int i = 0;i<currentListing.getEmployees().size();i++){
            System.out.println(i+1+")"+currentListing.getEmployees().get(i).getName());
        }
        input = sc.nextLine();
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=currentListing.getEmployees().size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Недопустимое значение");
                input = sc.nextLine();
                }
            }
        tempPlace = new Storage(name,currentListing.getEmployees().get(intInput-1));
        currentListing.getEmployees().get(intInput-1).setWorkingPlace(tempPlace);
        currentListing.addPlace(tempPlace);
        new Menu(currentListing);
        }

    public static void createSellingPlace(DocumentListing currentListing){
        boolean flag = false;
        int intInput = 0;
        Place tempPlace;
        System.out.println("Введите название нового пункта продаж:");
        Scanner sc  = new Scanner(System.in);
        String name = sc.nextLine();
        String input;
        System.out.println();
        System.out.println("Выберите ответственного сотрудника:");
        for (int i = 0;i<currentListing.getEmployees().size();i++){
            System.out.println(i+1+")"+currentListing.getEmployees().get(i).getName());
        }
        input = sc.nextLine();
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=currentListing.getFiles().size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Недопустимое значение");
                input = sc.nextLine();
            }
        }
        tempPlace = new SellingPlace(name,currentListing.getEmployees().get(intInput-1));
        currentListing.getEmployees().get(intInput-1).setWorkingPlace(tempPlace);
        currentListing.addPlace(tempPlace);
        new Menu(currentListing);
    }
    public static void removeEmployee(DocumentListing currentListing){
        Scanner sc = new Scanner(System.in);
        String input;
        boolean flag = false;
        int intInput = 0;
        System.out.println("Выберите сотрудника:");
        for (int i = 0;i<currentListing.getEmployees().size();i++){
            System.out.println(i+1+")"+currentListing.getEmployees().get(i).getName());
        }
        input = sc.nextLine();
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=currentListing.getFiles().size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Недопустимое значение");
                input = sc.nextLine();
            }
        }
        currentListing.getEmployees().get(intInput-1).getWorkingPlace().setEmployee(null);
        currentListing.getEmployees().remove(intInput-1);
        new Menu(currentListing);
    }
    public static void removeStorage(DocumentListing currentListing){
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Storage> tempStorageList = new ArrayList<Storage>();
        boolean flag = false;
        int intInput = 0;
        for (int i = 0;i<currentListing.getPlaces().size();i++){
            if (currentListing.getPlaces().get(i).getType().equals("Склад")){
                tempStorageList.add((Storage) currentListing.getPlaces().get(i));
            }
        }
        System.out.println("Выберите склад:");
        for (int i = 0;i<tempStorageList.size();i++){
            System.out.println(i+1+")"+tempStorageList.get(i).getName());
        }

        input = sc.nextLine();
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=tempStorageList.size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Недопустимое значение");
                input = sc.nextLine();
            }
        }
        Place currentStorage = tempStorageList.get(intInput-1);
        for(int i=0;i<currentListing.getPlaces().size();i++){
            if (currentListing.getPlaces().get(i).getName().equals(currentStorage.getName())){
                currentListing.getPlaces().remove(i);
            }
        }
        new Menu(currentListing);

    }
    public static void removeSellingPlace(DocumentListing currentListing){
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<SellingPlace> tempSellingPlaceList = new ArrayList<SellingPlace>();
        boolean flag = false;
        int intInput = 0;
        for (int i = 0;i<currentListing.getPlaces().size();i++){
            if (currentListing.getPlaces().get(i).getType().equals("Пункт продаж")){
                tempSellingPlaceList.add((SellingPlace) currentListing.getPlaces().get(i));
            }
        }
        System.out.println("Выберите пункт продаж:");
        for (int i = 0;i<tempSellingPlaceList.size();i++){
            System.out.println(i+1+")"+tempSellingPlaceList.get(i).getName());
        }

        input = sc.nextLine();
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=tempSellingPlaceList.size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                System.out.println("Недопустимое значение");
                input = sc.nextLine();
            }
        }

        Place currentSellingPlace = tempSellingPlaceList.get(intInput-1);
        for(int i=0;i<currentListing.getPlaces().size();i++){
            if (currentListing.getPlaces().get(i).getName().equals(currentSellingPlace.getName())){
                currentListing.getPlaces().remove(i);
            }
        }
        new Menu(currentListing);

    }
}
