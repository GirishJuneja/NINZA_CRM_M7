package package1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\Girish\\Desktop\\NinzaCRM_M7.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Campaign");
		Row r = sh.getRow(4);
		
		Cell c = r.createCell(5);
		c.setCellType(CellType.STRING);
		c.setCellValue("KAVYA");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Girish\\Desktop\\NinzaCRM_M7.xlsx");
		wb.write(fos);
		wb.close();
		

	}

}
