package com_parallel_testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Luma_Login {

	public static WebDriver driver;

    @BeforeSuite
	@Parameters({"browser","url"})
	public void openApplication(String br, String URL) {

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
    
    @Test(priority=1) //Test case-1
	public void loginFunctionality() {
		
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("nanitelagamsetti@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Nani@1234");
		driver.findElement(By.id("send2")).click();
	}
	@Test(priority=2) //Test Case-2
	public void logoutFunctionality() {
		
		driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
	}
	@Test(priority=3) //Test Case-3
	public void reloginFunctionality() {
		
		driver.findElement(By.xpath("(//li[@class='authorization-link'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("nanitelagamsetti@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Nani@1234");
		driver.findElement(By.id("send2")).click();	
	}
	@AfterSuite
	public void closeApplication() {
		driver.close();
	}
}
