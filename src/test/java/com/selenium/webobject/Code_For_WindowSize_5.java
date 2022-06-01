package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_WindowSize_5 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		//String projectPath=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w=new ChromeDriver();
		
		
	}

	@Test
	public void Code_For_WindowSize() throws InterruptedException {
		
	
		w.get("https://www.google.co.in/");
		Thread.sleep(2000);
		
	     
		//w.manage().window().maximize();
		
	//	w.manage().window().fullscreen();
		
	//	Set Resolution for execution -> class Dimension (width , heigth)
		
		Dimension d=new Dimension(1400, 800);
		w.manage().window().setSize(d);
		
			
	}

	@AfterTest
	public void afterTest() {
	}

}
