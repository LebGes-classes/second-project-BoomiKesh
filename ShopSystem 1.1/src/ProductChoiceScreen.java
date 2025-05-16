import java.util.Scanner;
public class ProductChoiceScreen {
    public ProductChoiceScreen(Place place,DocumentListing currentListing){


        Scanner sc = new Scanner(System.in);
        int size = place.getLength();
        boolean flag=false;
        String menuChoice = sc.next();
        while (flag == false) {
            if(NumberCheck.NumberCheck(menuChoice)){
                if(Integer.valueOf(menuChoice)>0 && Integer.valueOf(menuChoice)<=size){
                    flag = true;
                }else{
                    System.out.println("Неверная команда");
                    menuChoice = sc.next();
                }
            }else if(NumberCheck.NumberCheck(menuChoice)==false){
                if (menuChoice.equals("q")){
                    flag = true;
                }else{
                    System.out.println("Неверная команда");
                    menuChoice = sc.next();
                }
            }
        }
        if (menuChoice.equals("q")){

            new DocumentChoiceScreen(currentListing);
        }else{
            new ProductActionChoice(place,currentListing,(int) Integer.valueOf(menuChoice)-1);
        }
    }
}
