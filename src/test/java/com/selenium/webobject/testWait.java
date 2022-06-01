package com.selenium.webobject;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class testWait {

	public static void main(String[] args) throws Exception {
		
		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Browser_Driver\\chromedriver.exe");
		WebDriver w;
		w = new ChromeDriver();
		//w.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
		w.get("https://in.via.com/flight-tickets");

		w.findElement(By.id("wzrk-cancel")).click();

		// Select source location
		w.findElement(By.id("source")).clear();
		w.findElement(By.id("source")).sendKeys("Mumbai");
		
		Thread.sleep(2000);
		
		

		w.findElement(By.id("ui-id-1")).click();

		// Select target location

		w.findElement(By.id("destination")).clear();
		w.findElement(By.id("destination")).sendKeys("Pune");
		
		Thread.sleep(2000);


		w.findElement(By.id("ui-id-2")).click();
		
		Thread.sleep(2000);


		w.findElement(By.xpath("//*[@id=\"depart-cal\"]/div[3]/div[2]/div[6]/div[2]")).click();	

		Thread.sleep(2000);


		w.findElement(By.id("search-flight-btn")).click();
		
		

		//WebDriverWait wt=new WebDriverWait(w, 60);
	  //  wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

		Wait<WebDriver> fluentwt = new FluentWait<WebDriver>(w)
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		fluentwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]")));

		 
		String price = w.findElement(By.xpath("//*[@id=\"cheap_flight_container\"]/div[2]/div/div[1]/div[3]/span[2]"))
				.getText();
		
		
		System.out.println("Cheapest Flights is : " + price);
		

		w.quit();

	}

}
