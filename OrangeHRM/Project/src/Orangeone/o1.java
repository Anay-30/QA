package Orangeone;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class o1 {
	@Test
	public static void DataTest() throws InterruptedException {
		int k=0;
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");	
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		 List <WebElement> links = driver.findElements(By.tagName("a"));
		    for(int i=0;i<links.size();i++)
		        System.out.println(links.get(i).getText());
		    for(int i=0;i<links.size();i++){
		        links.get(i).click();
		        driver.navigate().back();
	}}}
