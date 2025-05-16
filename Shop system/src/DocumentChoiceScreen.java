import java.util.Scanner;
import java.io.*;
public class DocumentChoiceScreen {
    public DocumentChoiceScreen(){
        String temp;
        String documentChoice;
        String documentName = "";
        File chosenDocument;

        int counter = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите документ из списка:");
        File folder = new File("C:/My stuff/ProductList");

        //Вывод списка файлов
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            System.out.print(counter + ")");
            counter++;
            temp = file.toString();
            for (int i = 24; i < temp.length(); i++) {
                System.out.print(temp.charAt(i));
            }
            System.out.println();
        }
        temp = "";
        System.out.println("Чтобы выйти в меню нажмите q");


        //Выбор документа
        documentChoice = sc.next();
        if (NumberCheck.NumberCheck(documentChoice)){
            documentChoice = IntChoice(documentChoice,sc,counter);
        }else{
            documentChoice = StringChoice(documentChoice,sc,counter);
        }


        if (documentChoice=="q"){
            new ScreenCleaner();
            Menu.Menu();
        }else{
            chosenDocument = listOfFiles[Integer.valueOf(documentChoice)-1];
            temp = chosenDocument.toString();
            for (int i = 24; i<temp.length();i++){
                documentName = documentName + temp.charAt(i);
            }
            new ScreenCleaner();
            new DocumentPrint(chosenDocument);
            //new DocumentListing("C:/My stuff/ProductList/"+documentName);

        }
    }

    public String IntChoice(String documentChoice,Scanner sc,int counter){
        while (Integer.parseInt(documentChoice)>=counter || Integer.parseInt(documentChoice)<0) {
            System.out.println("Неверная команда");
            documentChoice = sc.next();
            if (NumberCheck.NumberCheck(documentChoice)){
                return IntChoice(documentChoice,sc,counter);
            }else{
                return StringChoice(documentChoice,sc,counter);
            }
        }
        return documentChoice;

    }
    private String StringChoice(String documentChoice,Scanner sc,int counter){
        while (documentChoice != "q") {
            System.out.println("Неверная команда");
            documentChoice = sc.next();
            if (NumberCheck.NumberCheck(documentChoice)){
                return IntChoice(documentChoice,sc,counter);
            }else{
                return StringChoice(documentChoice,sc,counter);
            }
        }
        return documentChoice;
    }
}
