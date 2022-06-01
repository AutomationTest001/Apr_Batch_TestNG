package com.selenium.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCode_WebDriverManager {

	WebDriver w;

	@Test(priority = 0, description = "Verify Chrome")
	public void chromeTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		w = new ChromeDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
	//	w.quit();

	}
	
	
	@Test(priority = 1, description = "Verify Firefox")
	public void firefoxTest() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();
		w = new FirefoxDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
	//	w.quit();

	}
	
	@Test(priority = 2, description = "Verify Edge")
	public void edgeTest() throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		w = new EdgeDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
		//w.quit();

	}

}
