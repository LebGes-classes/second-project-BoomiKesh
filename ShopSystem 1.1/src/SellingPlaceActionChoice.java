import java.util.Scanner;

public class SellingPlaceActionChoice {
    public SellingPlaceActionChoice(SellingPlace place,DocumentListing currentListing,int index){
        String stringAmount;
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Транспортировать");
        System.out.println("2) Продать");
        System.out.println("3) Отмена");
        String menuChoice = sc.next();
        while (!menuChoice.equals("1") && !menuChoice.equals("2")) {
            System.out.println("Неверная команда");
            menuChoice = sc.next();
        }
        if(menuChoice.equals("1")){
            new SendingChoice(currentListing,place,index);
        }else if(menuChoice.equals("2")){
            System.out.println("Введите кол-во:");
            stringAmount = sc.next();
            while (flag == false) {
                if (NumberCheck.NumberCheck(stringAmount)) {
                    if (Integer.valueOf(stringAmount) > 0 && Integer.valueOf(stringAmount) <= place.getProduct(Integer.valueOf(index)).getAmount()) {
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
            place.Sell(index,Integer.valueOf(stringAmount));
            new FileRewriter(currentListing);
            new Menu();
        }else if(menuChoice.equals("3")) {
            new ProductChoiceScreen(place, currentListing);
        }
    }
}
