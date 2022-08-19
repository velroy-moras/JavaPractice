package WritingDataToExcelSheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WritingToExcel {

    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet spreadsheet
                = workbook.createSheet("Availablilty PNR");

        XSSFRow row;

        Map<String, Object[]> availabilityRow
                = new TreeMap<String, Object[]>();

        availabilityRow.put(
                "1",
                new Object[] { "Roll No", "NAME", "Year" });

        availabilityRow.put("2", new Object[] { "128", "Aditya",
                "2nd year" });

        availabilityRow.put(
                "3",
                new Object[] { "129", "Narayana", "2nd year" });

        availabilityRow.put("4", new Object[] { "130", "Mohan",
                "2nd year" });

        availabilityRow.put("5", new Object[] { "131", "Radha",
                "2nd year" });

        availabilityRow.put("6", new Object[] { "132", "Gopal",
                "2nd year" });

        Set<String> keyid = availabilityRow.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = availabilityRow.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File("C:/savedexcel/GFGsheet.xlsx"));

        workbook.write(out);
        out.close();
    }
}
