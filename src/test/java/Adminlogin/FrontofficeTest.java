package Adminlogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpages;

public class FrontofficeTest extends Testbase{
	
	Loginpages objlog;
	Frontofficepage objff;
	
	public FrontofficeTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		objlog=new Loginpages();
		objlog.adminlogin(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		objff=new Frontofficepage();
		
	}
	
	@Test
	public void fftest()
	{
		objff.clickonfrontoffice();
		String actualtitle=objff.gettabletitle();
		String expectedtitle="Appointment Details";
		Assert.assertEquals(actualtitle, expectedtitle);
		objff.clickonvisitorbook();
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.close();
	}
	

}
