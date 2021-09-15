package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream( "C:\\Users\\admin\\eclipse-workspace\\POM\\src\\main\\java\\com\\crm\\"+ "\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void initialization() {
	
	
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\ChromeDriver 92.0.4515.107\\chromedriver_win32\\chromedriver.exe");
			 driver =new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		
		//handling windows and cookies
		
		driver.manage().window().maximize(); //to maximize window size
		driver.manage().deleteAllCookies();  //to delete all cookies from browser
			
		//dynamic wait
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.linkText("LOG IN")).click();
	
	}
}
