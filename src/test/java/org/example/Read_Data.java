package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class Read_Data {
    public String[][] read_Data() throws IOException, InvalidFormatException {
        File file = new File("C:\\Users\\khaled\\Downloads\\MobileShaft1\\src\\main\\resources\\Book.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        int number_of_rows = sheet.getPhysicalNumberOfRows();
        int number_of_columns = sheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows - 1][number_of_columns];
        for (int i = 1; i < number_of_rows; i++) {
            for (int a = 0; a < number_of_columns; a++) {
                XSSFRow row = sheet.getRow(i);
                myarray[i - 1][a] = row.getCell(a).toString();
            }
        }
        return myarray;
    }

    public String[][] read_DataTwo() throws IOException, InvalidFormatException {
        File file = new File("C:\\Users\\khaled\\Downloads\\MobileShaft1\\src\\main\\resources\\Book.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet2");
        int number_of_rows = sheet.getPhysicalNumberOfRows();
        int number_of_columns = sheet.getRow(0).getLastCellNum();
        String[][] myarray = new String[number_of_rows - 1][number_of_columns];
        for (int i = 1; i < number_of_rows; i++) {
            for (int a = 0; a < number_of_columns; a++) {
                XSSFRow row = sheet.getRow(i);
                myarray[i - 1][a] = row.getCell(a).toString();
            }
        }
        return myarray;
    }


}
