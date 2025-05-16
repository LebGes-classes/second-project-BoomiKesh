import java.util.Scanner;
public class StorageActionChoice {
    public StorageActionChoice(Place place,DocumentListing currentListing,int index){

        Scanner sc = new Scanner(System.in);
        System.out.println("1) Транспортировать");
        System.out.println("2) Отмена");
        String menuChoice = sc.next();
        while (!menuChoice.equals("1") && !menuChoice.equals("2")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        if(menuChoice.equals("1")){
            new SendingChoice(currentListing,place,index);
        }else if(menuChoice.equals("2")){
            new ProductChoiceScreen(place,currentListing);
        }
    }
}
