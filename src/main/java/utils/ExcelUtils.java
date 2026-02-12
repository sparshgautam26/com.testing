package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getData(String path, String sheet) throws Exception {

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheet(sheet);

        int rows = sh.getPhysicalNumberOfRows();
        int cols = sh.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows-1][cols];

        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                data[i-1][j] =
                        sh.getRow(i).getCell(j).toString();
            }
        }

        wb.close();
        return data;
    }
}
