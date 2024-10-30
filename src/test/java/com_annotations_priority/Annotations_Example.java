package com_annotations_priority;

import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;

public class Annotations_Example {

	@BeforeSuite 
	public void method1() {

		System.out.println("Before Suite is Executed");	
	}

	@AfterSuite
	public void method2() {
		System.out.println("After Suite is Executed");
	}

	@BeforeTest 
	public void method3() {
		System.out.println("Before test is executed");
	}

	@AfterTest
	public void method4() {

		System.out.println("After test is executed");
	}
	@Test
	public void method5() {

		System.out.println("Test is executed");
	}
	@BeforeClass
	public void method6() {

		System.out.println("Before Class is executed");
	}
	@AfterClass
	public void method7() {

		System.out.println("After Class is executed");
	}
	@BeforeMethod
	public void method8() {

		System.out.println("Before method is executed");
	}
	@AfterMethod
	public void method9() {

		System.out.println("After method is executed");
	}
}
