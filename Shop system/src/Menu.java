import java.util.Scanner;

public class Menu {
    public static void Menu() {
        System.out.println("1)Открыть документ");
        System.out.println("2)Инструкция");
        System.out.println("3)Выйти из программы");
        Scanner sc = new Scanner(System.in);
        String menuChoice = sc.next();
        while (!menuChoice.equals("1") && !menuChoice.equals("2") && !menuChoice.equals("3")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        switch (menuChoice) {
            case "1":
                new ScreenCleaner();
                new DocumentChoiceScreen();
                break;
            case "2":
                new ScreenCleaner();
                new ShowRules();
                break;
            case "3":
                break;
            default:
                System.out.println("Неверная команда");
                menuChoice = sc.next();
        }
        new ScreenCleaner();
    }
}