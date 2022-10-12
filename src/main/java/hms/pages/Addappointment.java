package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import hms.base.Testbase;

public class Addappointment extends Testbase {
	
	@FindBy(css="h3.box-title")WebElement tabletitle;
	@FindBy(css="div.box-tools>i")WebElement addappointment;
	@FindBy(xpath = "//h4[text()='Add Appointment']")WebElement screentitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement date;llll
	@FindBy(css="form#formadd input[name='patient_id']")WebElement patientid;
	@FindBy(css="form#formadd input[name='patient_name']")WebElement patientname;
	@FindBy(css="form#formadd select[name='gender']")WebElement gender;
	@FindBy(css="form#formadd input[name='email']")WebElement email;
	@FindBy(css="form#formadd input[name='mobileno']")WebElement phone;
	@FindBy(css="form#formadd span[]")WebElement doctor;
	@FindBy(css="form#formadd input[name='mobileno']")WebElement phone;
	@FindBy(css="form#formadd input[name='mobileno']")WebElement phone;
	

}
