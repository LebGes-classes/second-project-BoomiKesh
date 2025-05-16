import java.util.Scanner;
public class ShowRules {
    public ShowRules(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Управление:");
        System.out.println("w - вверх");
        System.out.println("a - влево");
        System.out.println("s - вниз");
        System.out.println("d - вправо");
        System.out.println("");
        System.out.println("Игрок обозначен @");
        System.out.println("");
        System.out.println("Цель:");
        System.out.println("Дойти до выхода (выход обозначен буквой E)");
        System.out.println("");
        System.out.println("Чтобы выйти в меню нажмите q");
        String input = sc.next();
        while (!input.equals("q")){
            System.out.println("Неверная команда");
            input = sc.next();
        }
        new ScreenCleaner();
        Menu.Menu();
    }
}

