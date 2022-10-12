package Adminlogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Loginpages;

public class LoginTest extends Testbase {

	
	Loginpages objlog;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	
	public void setup()
	{
		initialization();
		objlog=new Loginpages();
	}
	
	@Test
	
	public void adminloginlogout()
	{
		String actualtitle=objlog.getpagetitle();
		String expectedtitle="Smart Hospital : Hospital Management System";
		
		Assert.assertEquals(actualtitle, expectedtitle);
		
		Assert.assertTrue(objlog.tochecklogo());
		
		String actualscreentitle= objlog.togetscreentitle();
		String expectedscreentitle="Admin Login";
		Assert.assertEquals(actualscreentitle, expectedscreentitle);
		objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		objlog.adminlogout();
		
		
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
