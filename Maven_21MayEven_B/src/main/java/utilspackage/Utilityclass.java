package utilspackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilityclass 
{
	public static String fatchexcelsheetdata(String sheet,int row, int cell) throws EncryptedDocumentException, IOException
	{
		String path="D:\\Neha\\Automation\\testdata.xlsx";
		FileInputStream file= new FileInputStream(path);
		Workbook w=WorkbookFactory.create(file);
		String value;
			try
			{
				value=w.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			}
			catch(IllegalStateException e)
			{
				double d =w.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
				value=Double.toString(d);
				return value;
			}
		
		return value;
	}
	public static void CaptureScreenShot(WebDriver  driver,double testid) throws IOException
	{
		String path ="D:\\Neha\\screen\\image"+"test";
		String time = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File(path+testid+time+".jpeg");
		FileHandler.copy(src, dest);
	}

}
