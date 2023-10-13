package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSData {

    @DataProvider(name = "testData")
    public String[][] getData(Method method) throws IOException {
        String exelSheetName =method.getName();
        File file =new File("C:\\Users\\mosta\\IdeaProjects\\Guru99 Bank\\src\\Datasheet.xlsx");
        FileInputStream fileInputStream =new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheetName =workbook.getSheet(exelSheetName);

        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        System.out.println(totalCols);

        DataFormatter format = new DataFormatter();
        String[][] testData =new String[totalRows][totalCols];
        for (int i=1;i<=totalRows;i++){
            for(int j= 0;j<totalCols;j++){
                testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
            return testData;
    }
}
