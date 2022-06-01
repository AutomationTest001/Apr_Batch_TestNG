package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

@Listeners(com.selenium.listener_code.ListenersCode.class)
public class LoginMutualFund {

	WebDriver w;

	@BeforeTest
	public void preConditionBeforeTestExecution() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();

	}

	@Test(priority = 0,description = "Test case to verify login functionality using admin user",groups = "Login")
	public void loginAdminUser() throws Exception {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		
	}
	
	@Test(priority = 1,description="Test case to verify login functionality using test user",dependsOnMethods = "loginAdminUser" ,groups = "Login",invocationCount = 1,enabled = true)
	public void loginTestUser() throws Exception {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("tuser");
		w.findElement(By.name("passw")).sendKeys("tuser");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}
	
	@Test(priority = 2,description="Test case to verify login functionality using Jsmith user",dependsOnMethods = "loginAdminUser",groups = "Login")
	public void loginJSmithUser() throws Exception {

		w.get("http://demo.testfire.net/login.jsp");
		w.findElement(By.id("uid")).sendKeys("Jsmith");
		w.findElement(By.name("passw")).sendKeys("Demo1234");
		w.findElement(By.name("btnSubmit")).click();
		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();

	}

	@AfterTest
	public void postConditionAfterTestExecution() {

		w.close();

	}

}
