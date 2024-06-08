import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriver {

	public void getData(String testCaseName) throws IOException {
		ArrayList<String> a  = new ArrayList<String>();
		FileInputStream fil = new FileInputStream("C://Users//tatmoral2//Documents//test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fil);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int column = 0;

				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("test cases")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> cv= r.cellIterator();
						
						while(cv.hasNext()) {
							a.add(cv.next().getStringCellValue());
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {


	}
}
