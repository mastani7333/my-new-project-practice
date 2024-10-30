package com_dependsonmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class DependsOnMethods {
	
	public static WebDriver driver;
	public Select sc;
	@BeforeSuite
	public void openApplication() {
		
		driver= new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	@Test
	public void LoginFunctionality() {
		
		driver.findElement(By.id("username")).sendKeys("Venkat1997");
		driver.findElement(By.id("password")).sendKeys("73A35C");
		driver.findElement(By.id("login")).click();
	}
	@Test(dependsOnMethods= {"LoginFunctionality"})
	public void SearchHotelFunctionality() {
		
		WebElement Location=driver.findElement(By.id("location"));
	     sc=new Select(Location);
	     sc.selectByIndex(2);
	     
	     WebElement Hotels=driver.findElement(By.id("hotels"));
	     sc=new Select(Hotels);
	     sc.selectByVisibleText("Hotel Sunshine");
	     
	     WebElement NoofRooms=driver.findElement(By.id("room_no"));
	     
	     sc=new Select(NoofRooms);
	     sc.selectByIndex(3);
	     
	     driver.findElement(By.id("datepick_in")).sendKeys("05/09/2024");
	     driver.findElement(By.id("datepick_out")).sendKeys("06/09/2024");
	     
	   WebElement AdultspRoom=  driver.findElement(By.id("adult_room"));
	   
	   sc=new Select(AdultspRoom);
	   sc.selectByValue("2");
	   
	   driver.findElement(By.id("Submit")).click(); 
	}
	
	@Test(dependsOnMethods= {"SearchHotelFunctionality"})
	public void SelectHotel() {
		
		driver.findElement(By.id("radiobutton_1")).click();
		driver.findElement(By.id("continue")).click();	
	}
	
	@AfterSuite
	public void closeApplication() {
		
		driver.close();
	}
	

}
