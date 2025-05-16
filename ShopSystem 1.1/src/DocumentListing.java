import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;


public class DocumentListing {
    Place[] places;
    File[] files;
    public DocumentListing() {

        System.out.println("1");
        BufferedReader reader;
        String full_place_name;
        String full_employee_name;
        Employee currentEmployee;
        int counter;
        Storage temp_storage;
        SellingPlace temp_SellingPlace;
        ArrayList<String> stringProducts;

        File folder = new File("C:/My stuff/ProductList");
        File[] listOfFiles = folder.listFiles();
        files = listOfFiles;
        Place[] places = new Place[listOfFiles.length];
        int place_counter = 0;

        //По очереди обрабатываю каждый файл
        for (File file : listOfFiles) {
            System.out.println("2");
            stringProducts = new ArrayList<>();

            counter = 0;
            currentEmployee = null;
            try{

                //Считываю название места
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                full_place_name = line;

                //Считываю Имя сотрудника
                line = reader.readLine();
                full_employee_name = line;
                if (full_employee_name.length()!=28){

                    currentEmployee = new Employee(full_employee_name.substring(25));
                }
                System.out.println("3");


                //Если список пуст
                line = reader.readLine();
                if(Objects.equals(line, "Конец списка")){
                    System.out.println("Пуст");


                    if (full_place_name.substring(0, 5).equals("Склад")){
                        System.out.println("4");
                        if (currentEmployee!=null){
                            temp_storage = new Storage(full_place_name,currentEmployee,new Product[0]);
                            currentEmployee.setWorkingPlace(temp_storage);
                            places[place_counter] = temp_storage;
                            place_counter++;
                        }else{
                            temp_storage = new Storage(full_place_name,new Product[0]);
                            places[place_counter] = temp_storage;
                            place_counter++;
                        }
                    }else if (full_place_name.substring(0, 5).equals("Пункт")){
                        System.out.println("4");
                        if (currentEmployee!=null){
                            temp_SellingPlace = new SellingPlace(full_place_name,currentEmployee,new Product[0]);
                            currentEmployee.setWorkingPlace(temp_SellingPlace);
                            places[place_counter] = temp_SellingPlace;
                            place_counter++;
                        }else{
                            temp_SellingPlace = new SellingPlace(full_place_name,new Product[0]);
                            places[place_counter] = temp_SellingPlace;
                            place_counter++;
                        }
                    }else{
                        System.out.println("4");
                        System.out.println("Ошибка обработки списка");
                        break;
                    }


                //Если в списке есть хотя бы один элемент
                }else{
                    System.out.println("Есть");


                    while (!Objects.equals(line,"Конец списка")) {
                        if (line != null){
                            System.out.println(line);
                        }

                        stringProducts.add(line);
                        if (line != null){
                            System.out.println(line);
                        }
                        line = reader.readLine();
                        if (line != null){
                            System.out.println(line);
                        }
                        counter++;
                    }
                    System.out.println("4");

                    Product[] product_list = new Product[stringProducts.size()];
                    for (int i=0;i < product_list.length;i++){
                        product_list[i] = new Product(stringProducts.get(i));

                    }


                    if (full_place_name.substring(0, 5).equals("Склад")){
                        if (currentEmployee!=null){

                            temp_storage = new Storage(full_place_name,currentEmployee,product_list);
                            currentEmployee.setWorkingPlace(temp_storage);
                            places[place_counter] = temp_storage;
                            place_counter++;
                        }else{
                            temp_storage = new Storage(full_place_name,product_list);
                            places[place_counter] = temp_storage;
                            place_counter++;
                        }
                    }else if (full_place_name.substring(0, 5).equals("Пункт")){
                        if (currentEmployee!=null){
                            temp_SellingPlace = new SellingPlace(full_place_name,currentEmployee,product_list);
                            currentEmployee.setWorkingPlace(temp_SellingPlace);
                            places[place_counter] = temp_SellingPlace;
                            place_counter++;
                        }else{
                            temp_SellingPlace = new SellingPlace(full_place_name,product_list);
                            places[place_counter] = temp_SellingPlace;
                            place_counter++;
                        }
                    }else{
                        System.out.println("Ошибка обработки списка");
                        break;
                    }
                }
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            this.places = places;
        }
    }
    public Place get(int index){
        return places[index];
    }
}

