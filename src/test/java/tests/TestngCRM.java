package tests;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;
import pages.FreeCRM;

public class TestngCRM {
	public WebDriver driver;
	@Parameters({"uid","pwd"})
	@Test
	public void gettingData(String x,String y) throws InterruptedException, FindFailed
	{
		System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.freecrm.com");
		Thread.sleep(3000);
		FreeCRM c=new FreeCRM(driver);
		c.username(x);
		c.password(y);
		//SoftAssert a=new SoftAssert();
		//a.assertFalse(true);
	//Assert.assertTrue(false);
		c.login();
		Reporter.log("login completed");
		Screen s=new Screen();
		Pattern p=new Pattern("crm.png"); 
		s.click(p);
		Thread.sleep(2000);
		Reporter.log("successfully clicked");
		//a.assertAll();
		driver.close();
		
	} 
	

}
