import java.util.Scanner;
public class SendingChoice {
    public SendingChoice(DocumentListing currentListing, Place place,int index){
        Scanner sc = new Scanner(System.in);
        int transportingAmount;
        String stringAmount;
        boolean flag = false;
        int size = currentListing.places.length;
        for (int i=0;i<size;i++){
            System.out.println((i+1)+")"+currentListing.get(i).getName());
        }
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
                    new DocumentChoiceScreen(currentListing);
                }else{
                    System.out.println("Неверная команда");
                    menuChoice = sc.next();
                }
            }
        }
        if (menuChoice.equals("q")){
            new StorageActionChoice(place,currentListing,index);
        }else{
            System.out.println("Введите кол-во:");
            stringAmount = sc.next();
            while (flag == false) {
                if (NumberCheck.NumberCheck(stringAmount)) {
                    if (Integer.valueOf(stringAmount) > 0 && Integer.valueOf(stringAmount) <= place.getProduct(Integer.valueOf(menuChoice)-1).getAmount()) {
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

            place.transport(index,Integer.valueOf(stringAmount),currentListing.places[Integer.valueOf(menuChoice)-1]);

            new FileRewriter(currentListing);
            new Menu();
        }
    }
}