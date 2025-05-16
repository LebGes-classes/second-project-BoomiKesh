package org.example;

import java.util.Scanner;

public class ScreenChooser {
    public static void documentChoice(DocumentListing currentListing,boolean choiceState){
        System.out.println("Выберите документ:");
        for (int i = 0;i<currentListing.getPlaces().size();i++){
            System.out.println(i+1+")"+currentListing.getPlaces().get(i).getName());
        }
        System.out.println();
        System.out.println("Чтобы выйти нажмите q");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int intInput;
        boolean flag = false;
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=currentListing.getPlaces().size() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                if (input.equals("q")){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }
        }
        if (input.equals("q")){
            new Menu(currentListing);
        }else if (!choiceState){
            productChoice(currentListing,currentListing.getPlaces().get(Integer.valueOf(input)-1));
        }else if (choiceState){
            currentListing.getPlaces().get(Integer.valueOf(input)-1).getInfo();
            new Menu(currentListing);
        }
    }
    public static void productChoice(DocumentListing currentListing,Place currentPlace){
        Product tempProduct;
        System.out.println("Выберите продукт:");
        for (int i = 0;i<currentPlace.getLength();i++){
            tempProduct = currentPlace.getProduct(i);
            System.out.println(i+1+")"+tempProduct.getName()+" "+ tempProduct.getPrice()+".руб "+ tempProduct.getAmount()+" шт");
        }
        System.out.println();
        System.out.println("Чтобы выйти нажмите q");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int intInput;
        boolean flag = false;
        while(flag == false){
            if (NumericCheck.isNumeric(input)){
                intInput = Integer.valueOf(input);
                if (intInput<=currentPlace.getLength() && intInput>0){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }else{
                if (input.equals("q")){
                    flag = true;
                }else{
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }
        }
        if (input.equals("q")){
            documentChoice(currentListing,false);
        }else{
            if (currentPlace.getType().equals("Склад")){
                storageActionChoice(currentListing,currentPlace,Integer.valueOf(input)-1);
            }else{
                sellingPlaceActionChoice(currentListing,currentPlace,Integer.valueOf(input)-1);
            }
        }
    }
    public static void storageActionChoice(DocumentListing currentListing, Place currentPlace,int product_index){
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Транспортировать");
        System.out.println("2) Отмена");

        String menuChoice = sc.nextLine();
        while (!menuChoice.equals("1") && !menuChoice.equals("2")) {
            System.out.println("Неверная команда");
            menuChoice = sc.nextLine();
        }
        if(menuChoice.equals("1")){
            sendingChoice(currentListing,currentPlace,product_index);
        }else if(menuChoice.equals("2")){
            productChoice(currentListing,currentPlace);
        }
    }
    public static void sellingPlaceActionChoice(DocumentListing currentListing, Place currentPlace,int product_index){
        String stringAmount;
        SellingPlace currentSellingPlace;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Транспортировать");
        System.out.println("2) Продать");
        System.out.println("3) Отмена");
        String menuChoice = sc.nextLine();
        while (!menuChoice.equals("1") && !menuChoice.equals("2") && !menuChoice.equals("3")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        if(menuChoice.equals("1")){
            sendingChoice(currentListing,currentPlace,product_index);
        }else if(menuChoice.equals("2")){
            System.out.println("Введите кол-во:");
            stringAmount = sc.nextLine();
            while (flag == false) {
                if (NumericCheck.isNumeric(stringAmount)) {
                    if (Integer.valueOf(stringAmount) > 0 && Integer.valueOf(stringAmount) <= currentPlace.getProduct(Integer.valueOf(product_index)).getAmount()) {
                        flag = true;
                    } else {
                        System.out.println("Недопустимое значение");
                        stringAmount = sc.next();
                    }
                } else {
                    System.out.println("Недопустимое значение");
                    stringAmount = sc.next();
                }
            }
            currentSellingPlace =(SellingPlace) currentPlace;
            currentSellingPlace.Sell(product_index,Integer.valueOf(stringAmount));
            new Menu(currentListing);
        }else if(menuChoice.equals("3")) {
            productChoice(currentListing,currentPlace);
        }
    }

    public static void sendingChoice(DocumentListing currentListing, Place currentPlace,int product_index){
        System.out.println("Выберите место отправки:");
        for (int i=0;i<currentListing.getPlaces().size();i++){
            System.out.println(i+1+")"+currentListing.getPlaces().get(i).getName());
        }
        System.out.println();
        System.out.println("Чтобы выйти нажмите q");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String stringAmount="";
        int intInput;
        boolean flag = false;
        while(flag == false) {
            if (NumericCheck.isNumeric(input)) {
                intInput = Integer.valueOf(input);
                if (intInput <= currentListing.getPlaces().size() && intInput > 0) {
                    flag = true;
                } else {
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            } else {
                if (input.equals("q")) {
                    flag = true;
                } else {
                    System.out.println("Недопустимое значение");
                    input = sc.nextLine();
                }
            }
        }
        if (input.equals("q")){
            storageActionChoice(currentListing,currentPlace,product_index);
        }else {
            System.out.println("Введите кол-во:");
            stringAmount = sc.nextLine();
            flag = false;
            while (flag == false) {
                if (NumericCheck.isNumeric(stringAmount)) {
                    if (Integer.valueOf(stringAmount) > 0 && Integer.valueOf(stringAmount) <= currentPlace.getProduct(Integer.valueOf(product_index)).getAmount()) {
                        flag = true;
                        System.out.println(currentPlace.getProduct(Integer.valueOf(product_index)).getAmount());
                    } else {
                        System.out.println("Недопустимое значение");
                        stringAmount = sc.nextLine();
                    }
                } else {
                    System.out.println("Недопустимое значение");
                    stringAmount = sc.nextLine();
                }
            }
            currentPlace.transport(product_index,Integer.valueOf(stringAmount),currentListing.getPlaces().get(Integer.valueOf(input)-1));
            new Menu(currentListing);
        }
    }
}
