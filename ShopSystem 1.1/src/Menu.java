import java.util.Scanner;

public class Menu {
    public Menu(){

        DocumentListing currentListing = new DocumentListing();


        System.out.println("1)Операции с товаром");
        System.out.println("2)Создать/Закрыть склад");
        System.out.println("3)Создать/Закрыть пункт продаж");
        System.out.println("4)Создать/Закрыть склад");
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
                new DocumentChoiceScreen(currentListing);
                break;
            case "2":
                new ScreenCleaner();
                //new ShowRules();
                break;
            case "3":
                new ScreenCleaner();
                //new ShowRules();
                break;
            case "4":
                new ScreenCleaner();
                //new ShowRules();
                break;
            case "5":
                new ScreenCleaner();
                //new ShowRules();
                break;
            case "6":
                break;

            default:
                System.out.println("Неверная команда");
                menuChoice = sc.next();
        }

        new ScreenCleaner();
    }
}
