package com_Innovacational_Count;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Innovacational_Count {

	public static WebDriver driver;

	@BeforeSuite
	@Parameters({"browser","url"})
	public void openApplication(String br,String URL) {

		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {

			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
    @Test(invocationCount=5)
	public void loginFunctionality() {
		driver.findElement(By.id("username")).sendKeys("Venkat1997");
		driver.findElement(By.id("password")).sendKeys("73A35C");
		driver.findElement(By.id("login")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Click here to login again']")).click();
	
	}
    
    @AfterSuite
    public void closeApplication() {
    	driver.close();
    }
}
