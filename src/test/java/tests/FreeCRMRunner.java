package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pages.FreeCRM;

public class FreeCRMRunner  {
	Logger l=Logger.getLogger(FreeCRMRunner.class);
	
	@Test
	public void gettingData() throws BiffException, IOException, InterruptedException{
		PropertyConfigurator.configure("D:\\Batch235\\freecrm\\src\\test\\resources\\Log4j.properties");
		File f=new File("D:\\Batch235\\durgasoft\\crm.xls.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
		int nour=rsh.getRows();
		for(int i=1;i<nour;i++)
		{
			ExtentReports er=new ExtentReports("CRM.html",true);
			er.addSystemInfo("Host Name", "ashok");
			er.addSystemInfo("environment", "automation");
			er.addSystemInfo("User Name", "AshokReddy");
			ExtentTest et=er.startTest("CRMtesting");
			String u=rsh.getCell(0,i).getContents();
			String p=rsh.getCell(1,i).getContents();
			System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://www.freecrm.com");
			l.info("browser launched");
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			FreeCRM crm=new FreeCRM(driver);
			crm.username(u);
			et.log(LogStatus.PASS,"username field is passed");
			Thread.sleep(3000);
			crm.password(p);
			et.log(LogStatus.PASS,"passord field is passed");
			crm.login();
			Thread.sleep(2000);
		/*	if(driver.findElement(By.xpath("html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[9]/a")).isDisplayed())
			{
				et.log(LogStatus.PASS,"login successfully");
			}
			else
			{
				et.log(LogStatus.FAIL, "login not completed");
	             Thread.sleep(2000);
			}*/
			
			er.endTest(et);
			er.flush();
			driver.close();
			
			}
		
		
		
	}
	

}
