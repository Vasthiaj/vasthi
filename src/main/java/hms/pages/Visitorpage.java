package hms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Commonutility;
import hms.utility.Datepicker;

public class Visitorpage extends Testbase {

	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="div.box-tools>a")WebElement addvisitor;
	@FindBy(xpath = "//h4[text()=' Add Visitor']")WebElement screentitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement pname;
	@FindBy(css="form#formadd input[name='contact']")WebElement phno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idpro;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noper;
	@FindBy(css="form#formadd input[name='date']")WebElement datepicker;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement upfile;
	@FindBy(css="button.close")WebElement close;
	
	public Visitorpage()
	{
		PageFactory.initElements(driver, this);
	}
	//to get tabletitle
	
	public String gettabletitle()
	{
		return tabletitle.getText();
		
	}
	// to click on addvisitor
	
	public void clickonaddvisitor()
	{
		addvisitor.click();
	
	}
	// to get the screentitle
	
	public String getscreentitle()
	{
		waitforelement(screentitle);
		return screentitle.getText();
		
	}
	// to addvisitor details
	
	public void addvisitordetails(String data[])
	{
		Select drp=new Select(purpose);
		drp.selectByVisibleText(data[0]);
		pname.sendKeys(data[1]);
		phno.sendKeys(data[2]);
		idpro.sendKeys(data[3]);
		noper.sendKeys(data[5]);
		note.sendKeys(data[6]);
		datepicker.click();
		
		Datepicker dt=new Datepicker();
		dt.datpicker(data[4]);
		
		Commonutility.mouseclick(upfile);
		Commonutility.Fileupload(data[7]);
		
		close.click();
	}
	
}
