package Orangeone;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
public class o2 {
	@Test(dataProvider="data-set")
	public static void DataTest(String type, String username, String password) throws InterruptedException {
	System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");	
	driver.manage().window().maximize();
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.name("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
	if(type.equals("valid")){
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("MP_link")));
        System.out.println("Login Successful with username '"+ username + "' and password '"+password+"'");	
    }
	else  {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("spanMessage")));
		System.out.println("Login Failed with username '"+ username + "' and password '"+password+"'");}
	}      
	@DataProvider(name="data-set")
	public Object[][] DataSet(){
		return new Object[][] {
			{"invalid","adiiin","aaad123"},
			{"valid","admin","admin123"},
			{"invalid","admiiin","aaadmin123"},
		};
	}
}
