package com.selenium.basictest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) throws Exception{


		System.setProperty("webdriver.chrome.driver", ".\\Browser_Driver\\chromedriver.exe");
		
		WebDriver w=new ChromeDriver(); // open blank chrome browser 
		
		w.get("http://demo.testfire.net/login.jsp");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		
		w.findElement(By.name("passw")).sendKeys("admin");
		
		w.findElement(By.name("btnSubmit")).click();
		
		Thread.sleep(2000); // pause for 2 sec = 2000 millisec
		
		w.findElement(By.xpath("//*[@id=\"LoginLink\"]/font")).click();
		
		w.close();
		
		System.out.println("Admin have successfully logged into application !!!");
		

	}

}
