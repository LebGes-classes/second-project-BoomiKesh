
import java.io.*;

public class FileRewriter {
    public FileRewriter(DocumentListing currentListing) {
        File folder = new File("C:/My stuff/ProductList");
        File[] listOfFiles = folder.listFiles();
        int counter=0;
        Place currentPlace;
        String tempLine;
        Product currentProduct;

        for (File currentFile : listOfFiles) {
            try (FileWriter writer = new FileWriter(currentFile)) {
                currentPlace = currentListing.places[counter];

                // запись всей строки
                String first_line = currentPlace.getName()+"\n";
                String second_line = "Ответственный сотрудник: "+currentPlace.getEmployee().getFullName()+"\n";

                writer.write(first_line);
                writer.write(second_line);

                for (int i = 0;i<currentPlace.getLength();i++){
                    currentProduct = currentPlace.getProduct(i);

                    tempLine = (i+1)+")"+currentProduct.getName()+" "+currentProduct.getPrice()+"rub "+currentProduct.getAmount()+"-шт\n";
                    System.out.println(tempLine);
                    writer.write(tempLine);
                }
                writer.write("Конец списка\n");

                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            counter++;
        }
    }
}
