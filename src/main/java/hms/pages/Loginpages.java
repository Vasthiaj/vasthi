package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class Loginpages extends Testbase{
	
	//webelements
	
	@FindBy(css="img[src='http://triotend.com/tts/backend/images/s_logo.png']")WebElement logo;
	
	@FindBy(css="h3.font-white")WebElement logintitle;
	
	@FindBy(css="input#email")WebElement username;
	
	@FindBy(css="input#password")WebElement password;
	
	@FindBy(css="button.btn")WebElement signin;
	
	@FindBy(css="img.topuser-image")WebElement profile;
	
	@FindBy(css="div.sspass>a:nth-child(3)")WebElement logout;
	
	//pagefactory initilization
	
	public Loginpages()
	{
		
		PageFactory.initElements(driver, this);
	}
	
	// to get pagetitle
	
	public String getpagetitle()
	{
		return driver.getTitle();
		
	}
	
	// to check logo
	
	public boolean tochecklogo()
	{
		return logo.isDisplayed();
		
	}
	
	//to get login screen title
	
	public String togetscreentitle()
	{
		return logintitle.getText();
		
	}
	
	public void adminlogin(String uname,String pass) 
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
		signin.click();
	}
	
	public void adminlogout()
	{
		profile.click();
		logout.click();
		
	}
	
	
	
	
	

}
