package maven2_utility;

import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityClass_ExcelSheet
{
	 static Sheet mySheet;
	public static  String pathForExcelSheet(int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException 
	{
	//excel sheet path
		Reporter.log("opening browser.. ",true);
		FileInputStream myFile=new FileInputStream("F:\\Excel-Data\\zerodaDDF.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("sheet1");
		String value = mySheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		Reporter.log("browser open successfully.... . ",true);
		return value;
		
	}
	
	
}
