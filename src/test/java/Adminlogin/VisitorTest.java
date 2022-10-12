package Adminlogin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.Frontofficepage;
import hms.pages.Loginpages;
import hms.pages.Visitorpage;
import hms.utility.ReadExcel;

public class VisitorTest extends Testbase {

	Loginpages objlog;
	Frontofficepage objff;
	Visitorpage objvis;
	
	public VisitorTest()
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
		objff.clickonfrontoffice();
		objff.clickonvisitorbook();
		
		objvis=new Visitorpage();
	}
	
	@DataProvider
	public Object[][] getvistordata()
	{
		Object[][] data=ReadExcel.getTestData("Vistordata");
		return data;
		
	}
	
	
	
	@Test(dataProvider="getvistordata")
	
	public void addvisitordetails(String vis[])
	{
		String actualtitle=objvis.gettabletitle();
		String expectedtitle="Visitor List";
		Assert.assertEquals(actualtitle, expectedtitle);
		
		objvis.clickonaddvisitor();
		
		String actualscreentitle=objvis.getscreentitle();
		String expectedscreentitle="Add Visitor";
		Assert.assertEquals(actualscreentitle, expectedscreentitle);
		
		objvis.addvisitordetails(vis);
		
	}
	
	
}
