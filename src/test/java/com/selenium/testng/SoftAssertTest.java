package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SoftAssertTest {

	WebDriver w;
	SoftAssert sft;

	@BeforeTest
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0, description = "Verify Login Page Functionality")
	public void verifyLoginPage() throws Exception {
		
		sft=new SoftAssert();

		w.get("http://altoromutual.com:8080/login.jsp");

		String loginPageTitle = w.getTitle();
		sft.assertEquals(loginPageTitle, "Altoro Mutual");

		String loginPageURL = w.getCurrentUrl();
		sft.assertTrue(loginPageURL.contains("login"), "Login Page url doesn't contains login");

		WebElement loginPageLabel = w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String loginPageLabelText = loginPageLabel.getText();
		sft.assertTrue(loginPageLabelText.contains("Login"), "Login Label is different");

		WebElement loginButton = w.findElement(By.name("btnSubmit"));
		sft.assertTrue(loginButton.isDisplayed(), "Login Button not present ");

		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.name("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();

		
		sft.assertAll();
	}

	@Test(priority = 1, description = "Verify Home Page Functionality", dependsOnMethods = "verifyLoginPage")
	public void verifyHomePage() throws Exception {
		
		sft=new SoftAssert();

		String homePageTitle = w.getTitle();
		sft.assertEquals(homePageTitle, "Altoro Mutual");

		WebElement homePageLabel = w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
		String homePageLabelText = homePageLabel.getText();
		sft.assertTrue(homePageLabelText.contains("Admin"), "home page Label is different");

		Thread.sleep(2000);
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		sft.assertAll();
	}

	@AfterTest
	public void closeBrowser() {

		w.close();
	}

}
