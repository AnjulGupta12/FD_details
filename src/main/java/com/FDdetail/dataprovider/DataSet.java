
 package com.FDdetail.dataprovider;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.FDdetail.base.TestBase;
import com.google.common.collect.Table.Cell;

 


public class DataSet extends TestBase {

 

    String filePath=System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.xlsx";

 

    @DataProvider(name="testData")

    public String[][] getExcelData() throws IOException {

        String[][] data = new String[1][3];
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFRow row;// = sheet.getRow(0);
        //int noOfRows = sheet.getPhysicalNumberOfRows();
        //int noOfCols = row.getLastCellNum();
        XSSFCell cell;
        //data = new String[noOfRows - 1][noOfCols];
        //System.out.println(noOfCols);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 3; j++) {
                row = sheet.getRow(1);
                cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
                //System.out.println(data[i][j]);
                //System.out.println("3");
            }
        }

        return data;
    }
}