package org.example;

import java.util.Scanner;

public class Menu {
    public Menu(){

        DocumentListing currentListing = new DocumentListing();
        try{
            currentListing.ReadFiles();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("1)Операции с товаром");
        System.out.println("2)Создать/Закрыть склад");
        System.out.println("3)Создать/Закрыть пункт продаж");
        System.out.println("4)Нанять/уволить сотрудника");
        System.out.println("5)Информация о складе/пункте продаж");
        System.out.println("6)Выйти из программы");
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.next();
        while (!menuChoice.equals("1") && !menuChoice.equals("2")&& !menuChoice.equals("3")&& !menuChoice.equals("4")&& !menuChoice.equals("5") && !menuChoice.equals("6")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        switch (menuChoice) {
            case "1":
                new ScreenCleaner();
                ScreenChooser.documentChoice(currentListing,false);
                break;
            case "2":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Создать склад");
                System.out.println("2)Закрыть склад");
                menuChoice = sc.next();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.next();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createStorage(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeStorage(currentListing);
                }
                break;
            case "3":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Создать пункт продаж");
                System.out.println("2)Закрыть пункт продаж");
                menuChoice = sc.nextLine();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.nextLine();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createSellingPlace(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeSellingPlace(currentListing);
                }
                break;
            case "4":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Нанять сотрудника");
                System.out.println("2)Уволить сотрудника");
                menuChoice = sc.nextLine();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.nextLine();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createEmployee(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeEmployee(currentListing);
                }
                break;
            case "5":
                new ScreenCleaner();
                ScreenChooser.documentChoice(currentListing,true);
                break;
            case "6":
                try {
                    XlsxWriter.CreateFiles(currentListing);
                    XlsxWriter.FillFiles(currentListing);
                } catch (Exception e) {
                    System.out.println();
                }
                break;

            default:
                System.out.println("Неверная команда");
                menuChoice = sc.next();
        }

        new ScreenCleaner();
    }
    public Menu(DocumentListing currentListing){



        System.out.println("1)Операции с товаром");
        System.out.println("2)Создать/Закрыть склад");
        System.out.println("3)Создать/Закрыть пункт продаж");
        System.out.println("4)Нанять/уволить сотрудника");
        System.out.println("5)Информация о складе/пункте продаж");
        System.out.println("6)Выйти из программы");
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.next();
        while (!menuChoice.equals("1") && !menuChoice.equals("2")&& !menuChoice.equals("3")&& !menuChoice.equals("4")&& !menuChoice.equals("5") && !menuChoice.equals("6")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        switch (menuChoice) {
            case "1":
                new ScreenCleaner();
                ScreenChooser.documentChoice(currentListing,false);
                break;
            case "2":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Создать склад");
                System.out.println("2)Закрыть склад");
                menuChoice = sc.nextLine();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.nextLine();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createStorage(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeStorage(currentListing);
                }
                break;
            case "3":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Создать пункт продаж");
                System.out.println("2)Закрыть пункт продаж");
                menuChoice = sc.nextLine();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.nextLine();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createSellingPlace(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeSellingPlace(currentListing);
                }
                break;
            case "4":
                new ScreenCleaner();
                System.out.println("Выберите действие:");
                System.out.println("1)Нанять сотрудника");
                System.out.println("2)Уволить сотрудника");
                menuChoice = sc.nextLine();
                while(!menuChoice.equals("1") && !menuChoice.equals("2")){
                    System.out.println("Недопустимое значение");
                    menuChoice=sc.nextLine();
                }
                if (menuChoice.equals("1")){
                    ListingEditor.createEmployee(currentListing);
                }else if(menuChoice.equals("2")){
                    ListingEditor.removeEmployee(currentListing);
                }
                break;
            case "5":
                new ScreenCleaner();
                ScreenChooser.documentChoice(currentListing,true);
                break;
            case "6":
                try {
                    XlsxWriter.CreateFiles(currentListing);
                    XlsxWriter.FillFiles(currentListing);
                } catch (Exception e) {
                    System.out.println();
                }
                break;

            default:
                System.out.println("Неверная команда");
                menuChoice = sc.next();
        }

        new ScreenCleaner();
    }
}
