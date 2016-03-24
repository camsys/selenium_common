/**
 * This class contains methods for interacting with excel spreadsheets.  
 * 
 * @author mswanton
 */

package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.*;

public class ExcelUtilities {
    public static ArrayList<String[]> getDataFromExcel(String filepath,
            String sheet) {
        ArrayList<String[]> excelData = new ArrayList<String[]>();
        try {
            FileInputStream excelFile = new FileInputStream(filepath);
            HSSFWorkbook wb = new HSSFWorkbook(excelFile);
            HSSFSheet excelSheet = wb.getSheet(sheet);
            HSSFRow labels = excelSheet.getRow(0);
            int numCols = labels.getLastCellNum();

            for (int i = 1; i <= excelSheet.getLastRowNum(); i++) {
                HSSFRow row = excelSheet.getRow(i);
                if (row.getCell(0) == null
                        || !row.getCell(0).toString().equalsIgnoreCase("false")) {
                    String[] excelRow = new String[numCols];
                    for (int j = 1; j < numCols; j++) {
                        if (row.getCell(j) != null) {
                            excelRow[j - 1] = row.getCell(j).toString();
                        } else {
                            excelRow[j - 1] = ""; // Catches empty cells
                        }
                    }
                    excelData.add(excelRow);
                }
            }
            excelFile.close();
            wb.close();
        }

        catch (IOException e) {
            System.out.println("File not found.");
        }
        return excelData;
    }
}
