package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.utility.Acitivitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Testbase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eve;
	public static Acitivitycapture acp;
	
	public Testbase()
	{
		try {
			FileInputStream ipconfig=new FileInputStream("./src/main/java/hms/config/appconfig.properties");
			prop=new Properties();
			prop.load(ipconfig);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		
		String browsername=prop.getProperty("BROWSER");
		
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			if(prop.getProperty("HEADLESS").equals("true"))
			{
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("--headless");
				driver=new ChromeDriver(opt);
			}
			
			else
			{
				driver=new ChromeDriver();
			}
			
		}
		else if(browsername.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
		{
			System.out.println("please check the browser name");
		}
		
		// basic methods
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.get(prop.getProperty("URL"));
		
		//Log generation script
		
		acp=new Acitivitycapture();
		eve=new EventFiringWebDriver(driver);
		eve.register(acp);
		driver=eve;
		
		
	}
	
	public void waitforelement(WebElement el)
	{
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(20));
		wt.until(ExpectedConditions.visibilityOf(el));
	}
}
