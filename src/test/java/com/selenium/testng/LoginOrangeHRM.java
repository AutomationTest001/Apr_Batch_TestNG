package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginOrangeHRM {

	WebDriver w;

	@BeforeTest
	public void preConditionBeforeTestExecution() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();

	}

	@Test(priority = 0 ,description = "Validate Login functaionality",groups="Login - Orange HRM")
	public void loginOrangeHRM() throws Exception {
		
		w.get("https://opensource-demo.orangehrmlive.com/");		
		w.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");		
		w.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("admin123");		
		w.findElement(By.cssSelector("input.button")).click();		
		Thread.sleep(3000);		
		w.findElement(By.id("welcome")).click();		
		Thread.sleep(2000);		
		w.findElement(By.linkText("Logout")).click();
		
	}

	@AfterTest
	public void postConditionAfterTestExecution() {

		w.close();

	}

}
