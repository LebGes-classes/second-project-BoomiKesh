package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class XlsxWriter {
    public static void CreateFiles(DocumentListing currentListing){
        ArrayList<Place> finalPlaces = currentListing.getPlaces();
        String filePath = "C:\\Users\\ThinkBook\\OneDrive\\Desktop\\Учёба\\Прога\\Java\\second-project-BoomiKesh\\ShopSystem 1.2\\ShopSystem1.2\\src\\main\\resources\\Output\\";
        for (Place currentPlace: finalPlaces){
            try (XSSFWorkbook workbook = new XSSFWorkbook()){
                try (FileOutputStream fileOutput = new FileOutputStream(filePath+currentPlace.getName()+".xlsx")){
                    workbook.write(fileOutput);
                }
            }catch(Exception e){
                System.err.println("Ошибка при создании файла");
            }
        }
    }
    public static void FillFiles(DocumentListing currentListing){
        ArrayList<Place> finalPlaces = currentListing.getPlaces();
        Workbook workbook;
        File file;
        Product tempProduct;

        String filePath = "C:\\Users\\ThinkBook\\OneDrive\\Desktop\\Учёба\\Прога\\Java\\second-project-BoomiKesh\\ShopSystem 1.2\\ShopSystem1.2\\src\\main\\resources\\Output\\";
        for (Place currentPlace: finalPlaces){
            file = new File(filePath+currentPlace.getName()+".xlsx");
            try (FileInputStream fis = new FileInputStream(file)) {
                System.out.println("0");
                workbook = WorkbookFactory.create(fis);
//                Sheet sheet = workbook.getSheetAt(0);
                Sheet sheet = workbook.createSheet("Лист 1");
                for (int i = sheet.getLastRowNum(); i >= 0; i--) {
                    sheet.removeRow(sheet.getRow(i));
                }

                Row row = sheet.createRow(0);
                Cell cell = row.createCell(0);
                cell.setCellValue(currentPlace.getType());
                cell = row.createCell(1);
                cell.setCellValue(currentPlace.getName());
                row = sheet.createRow(1);
                cell = row.createCell(0);
                cell.setCellValue("Ответственный сотрудник");
                cell = row.createCell(1);
                cell.setCellValue(currentPlace.getEmployee().getName());
                sheet.createRow(2);
                row = sheet.createRow(3);
                cell = row.createCell(0);
                cell.setCellValue("Номер");
                cell = row.createCell(1);
                cell.setCellValue("Название");
                cell = row.createCell(2);
                cell.setCellValue("Цена(.руб)");
                cell = row.createCell(3);
                cell.setCellValue("Кол-во");

                for(int i = 4;i<currentPlace.getLength()+4;i++){
                    tempProduct = currentPlace.getProduct(i-4);
                    row = sheet.createRow(i);
                    cell = row.createCell(0);
                    cell.setCellValue(i-3);
                    cell = row.createCell(1);
                    cell.setCellValue(tempProduct.getName());
                    cell = row.createCell(2);
                    cell.setCellValue(tempProduct.getPrice());
                    cell = row.createCell(3);
                    cell.setCellValue(tempProduct.getAmount());
                }
                try (FileOutputStream fos = new FileOutputStream(filePath+currentPlace.getName()+".xlsx")) {
                    workbook.write(fos);
                }


                workbook.close();
            }catch(Exception e){
                System.err.println("Ошибка при заполнении файла");
            }
        }
    }
}
