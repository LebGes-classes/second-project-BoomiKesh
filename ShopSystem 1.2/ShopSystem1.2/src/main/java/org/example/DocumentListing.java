package org.example;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.ArrayList;

public class DocumentListing {
    private ArrayList<Place> places;
    private ArrayList<File> files;
    private ArrayList<Employee> employees;
    public void ReadFiles() throws Exception{
        this.files = new ArrayList<File>();
        this.places = new ArrayList<Place>();
        this.employees = new ArrayList<Employee>();
        File folder = new File("src\\main\\resources");
        File[] listOfFiles = folder.listFiles();
        ArrayList<File> listOfXlsx = new ArrayList<File>();
        String tempFileName;
        for(int i=0;i< listOfFiles.length;i++){
            tempFileName = listOfFiles[i].getName();
            if (tempFileName.substring(tempFileName.length()-5).equals(".xlsx")){
                listOfXlsx.add(listOfFiles[i]);
            }
        }
        ArrayList<Place> places= new ArrayList<>(listOfFiles.length);
        ArrayList<ArrayList<String>> tempTable;
        int placecounter=0;
        String placeType;
        String placeName;
        String responsibleEmloyeeName;
        Employee responsibleEmployee;
        Place tempPlace;
        String tempProductName;
        String tempProductPrice;
        String tempProductAmount;
        ArrayList<Product> tempProductList;
        for (File tempfile : listOfXlsx) {
            files.add(tempfile);

            tempTable = new ArrayList<>();
            tempProductList = new ArrayList<>();
            FileInputStream file = new FileInputStream(tempfile);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            for (Row row : sheet) {
                ArrayList<String> rowData = new ArrayList<>();
                int cellsCount = row.getLastCellNum();

                for (int cellIndex = 0; cellIndex < cellsCount; cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    String value = "";

                    if (cell != null) {
                        value = formatter.formatCellValue(cell).trim();
                    }

                    rowData.add(value);
                }
                tempTable.add(rowData);
            }
            workbook.close();
            file.close();
            placeType = tempTable.get(0).get(0);
            placeName = tempTable.get(0).get(0)+" "+tempTable.get(0).get(1);
            responsibleEmloyeeName = tempTable.get(1).get(1);
            responsibleEmployee = new Employee(responsibleEmloyeeName);
            try {
                for (int i = 3; i < tempTable.size(); i++) {

                    tempProductName = tempTable.get(i).get(1);
                    tempProductPrice = tempTable.get(i).get(2);
                    tempProductAmount = tempTable.get(i).get(3);
                    tempProductList.add(new Product(tempProductName,Integer.valueOf(tempProductAmount), Integer.valueOf(tempProductPrice)));
                    //System.out.println(tempProductName+" was addded");
                }

                if (placeType.equals("Склад")) {
                    tempPlace = new Storage(placeName, responsibleEmployee, tempProductList);
                    responsibleEmployee.setWorkingPlace(tempPlace);
                    this.places.add(tempPlace);
                    this.employees.add(responsibleEmployee);


                } else if (placeType.equals("Пункт продаж")) {
                    tempPlace = new SellingPlace(placeName, responsibleEmployee, tempProductList);
                    responsibleEmployee.setWorkingPlace(tempPlace);
                    this.places.add(tempPlace);
                    this.employees.add(responsibleEmployee);

                }
            } catch (Exception e){
                if (placeType.equals("Склад")) {
                    tempPlace = new Storage(placeName, responsibleEmployee, new ArrayList<Product>());
                    responsibleEmployee.setWorkingPlace(tempPlace);
                    this.places.add(tempPlace);
                    this.employees.add(responsibleEmployee);
                } else if (placeType.equals("Пункт продаж")) {
                    tempPlace = new SellingPlace(placeName, responsibleEmployee, new ArrayList<Product>());
                    responsibleEmployee.setWorkingPlace(tempPlace);
                    this.places.add(tempPlace);
                    this.employees.add(responsibleEmployee);
                }
            }
        }


    }

    public ArrayList<File> getFiles() {
        return files;
    }
    public ArrayList<Place> getPlaces(){
        return places;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public void addEmployee(Employee newEmployee){
        this.employees.add(newEmployee);
    }
    public void addPlace(Place newPlace){
        this.places.add(newPlace);
    }

}
