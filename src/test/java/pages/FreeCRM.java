   package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeCRM {
	WebDriver driver;
	@FindBy(name="username")
	public WebElement uid;
	@FindBy(name="password")
	public WebElement pwd;
	@FindBy(xpath="//*[@value='Login']")
	public WebElement submit;
	public FreeCRM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public void username(String x)
		{
			uid.sendKeys(x);
		}
		public void password(String y){
			pwd.sendKeys(y);
		}
		public void login(){
			submit.click();
		}
	}


