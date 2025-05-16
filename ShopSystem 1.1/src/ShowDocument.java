import java.io.*;

public class ShowDocument {
    public ShowDocument(File file){
        BufferedReader reader;
        String full_name;
        try{
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            full_name = line;
            line = reader.readLine();

            while (!line.equals("Конец списка")) {

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
