package com_annotations_priority;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Priority {
	
	WebDriver driver;
	
	@BeforeSuite
	public void openApplicationMethod() {
		driver=new ChromeDriver();
		
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@Test(priority=3)
	public void loginFunctionality() throws InterruptedException {
		
		driver.findElement(By.id("username")).sendKeys("Venkat1997");
		driver.findElement(By.id("password")).sendKeys("73A35C");
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(5000);
	}
	@Test(priority=1)
	public void registrationFunctionality() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='New User Register Here']")).click();
		driver.findElement(By.id("username")).sendKeys("Venkat");
		driver.findElement(By.id("password")).sendKeys("Venkat@123");
		driver.navigate().back();
		Thread.sleep(5000);	
	}
	@Test(priority=2)
	public void forgotPasswordFunctionality() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Forgot Password?']")).click();
		driver.findElement(By.id("emailadd_recovery")).sendKeys("nanitelagamsetti@gmail.com");
		driver.navigate().back();
		Thread.sleep(5000);
		
	}
	
	@AfterSuite
	public void closeApp() {
		driver.close();
	}

}
