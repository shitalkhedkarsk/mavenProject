package maven2_utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityClass_using_PropertyFie {
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
		public static void takeScreenshot(WebDriver driver, int TCID) throws IOException
		{
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination=new File("F:\\screenshot\\kite "+TCID+".png");
			FileHandler.copy(source, destination);
			Reporter.log("screenshot taken for TC "+TCID,true);
			}
		public static String propertyFile(String key) throws IOException
		{
			Properties pro=new Properties();
			FileInputStream fileObj=new FileInputStream("F:\\eclipse\\mavenprject2\\propertyfileFormaven2.properties");
			pro.load(fileObj);
			String value = pro.getProperty(key);
			return value;
		
		}

}
