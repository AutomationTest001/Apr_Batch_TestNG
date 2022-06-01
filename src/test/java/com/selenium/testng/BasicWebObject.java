package com.selenium.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class BasicWebObject {
	
	WebDriver w;

	@BeforeTest
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		w = new ChromeDriver();
	}

	@Test(priority = 0,description = "Handle TextBox")
	public void handleTextBox() {
		
		w.get("http://demo.automationtesting.in/Register.html");
		
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='FirstName']")).sendKeys("Steve");
		
		w.findElement(By.cssSelector("input[ng-model='LastName']")).clear();
		w.findElement(By.cssSelector("input[ng-model='LastName']")).sendKeys("Jones");
		
		
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).clear();
		w.findElement(By.cssSelector("textarea[ng-model='Adress']")).sendKeys("Sample testing addresss");
		
	}
	
	@Test(priority = 1,description = "Handle radio Button")
	public void handleRadioButton() {
		
		w.findElement(By.cssSelector("input[value='Male']")).click();
		
	}
	
	@Test(priority = 2,description = "Handle CheckBox")
	public void handleCheckBox() {
		
		w.findElement(By.id("checkbox1")).click();
		w.findElement(By.id("checkbox3")).click();

		
	}
	
	
	@Test(priority = 3,description = "Handle Drop Down List")
	public void handleDropDown() {
		
		WebElement skillsDropDown=w.findElement(By.id("Skills"));
		
		Select sl=new Select(skillsDropDown);
		
        // sl.selectByIndex(5);
		//sl.selectByValue("Data Analytics");
		//sl.selectByVisibleText("Java");
		
		System.out.println("\nPrint Value from Drop-Down List : \n");
		
		List<WebElement> valuesFromDropDown=sl.getOptions();
		
		// Drop Down List -> Index wise -> Text
		
		for(int i=0;i<valuesFromDropDown.size();i++) {
			
			System.out.println(valuesFromDropDown.get(i).getText());
		}

		
		
		
		
	}

	@AfterTest
	public void closeBrowser() {
	}

}
