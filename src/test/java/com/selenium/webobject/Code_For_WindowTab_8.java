package com.selenium.webobject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Code_For_WindowTab_8 {

	WebDriver w;

	@BeforeTest
	public void beforeTest() {

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Browser_Driver\\chromedriver.exe");
		w=new ChromeDriver();
		w.manage().window().maximize();	
		
	}


		
	
	@Test(priority=0,description="Test case to handle Flipkart Tab")
	public void tabFlipkart() throws Exception {
		
		
		w.get("https://www.flipkart.com/home-kitchen/home-appliances/washing-machines/fully-automatic-front-load~function/pr?sid=j9e%2Cabm%2C8qx&otracker=nmenu_sub_TVs%20%26%20Appliances_0_Fully%20Automatic%20Front%20Load");
		
		w.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a")).click();
		
        Thread.sleep(2000);
        
          
       Set <String> tab=w.getWindowHandles();
       
       System.out.println(tab);
       
       Object [] tabSplit=tab.toArray();
       
       System.out.println(tabSplit[0]);
       System.out.println(tabSplit[1]);
       
       w.switchTo().window(tabSplit[0].toString());
       System.out.println("Tab 1 title : "+w.getTitle());
       
       Thread.sleep(2000);
       
       w.switchTo().window(tabSplit[1].toString());
       System.out.println("Tab 2 title : "+w.getTitle());
       
       Thread.sleep(2000);

       w.switchTo().window(tabSplit[0].toString());
       System.out.println("Tab 1 title : "+w.getTitle());
       
       Thread.sleep(2000);
       
       w.switchTo().window(tabSplit[1].toString());
       System.out.println("Tab 2 title : "+w.getTitle());
      
        
	}
	@AfterTest
	public void afterTest() {
		w.quit();
		
	}

}
