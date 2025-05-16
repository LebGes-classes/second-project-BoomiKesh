import java.io.*;

public class DocumentPrint {
    public DocumentPrint(File file){
        BufferedReader reader;
        String full_name="";

        

        try{
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            full_name = line;
            line = reader.readLine();

            while (line != null) {

                new Product(line);
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
