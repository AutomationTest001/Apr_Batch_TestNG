package com.selenium.webobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCode {

	WebDriver w;

	@Test(priority = 0, description = "Verify Chrome")
	public void chromeTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
		w.quit();

	}
	
	
	@Test(priority = 1, description = "Verify Firefox")
	public void firefoxTest() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", ".\\Browser_Driver\\geckodriver.exe");
		w = new FirefoxDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
		w.quit();

	}
	
	@Test(priority = 2, description = "Verify Edge")
	public void edgeTest() throws InterruptedException {

		System.setProperty("webdriver.edge.driver", ".\\Browser_Driver\\msedgedriver.exe");
		w = new EdgeDriver();
		w.get("https://www.google.com");
		Thread.sleep(2000);
		w.quit();

	}

}
