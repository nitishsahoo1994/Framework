package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()   {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("/FreeCRMTest/src/main/java/com/confrig/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialisation() {
		String browser=prop.getProperty("brower");
		if(browser.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FF")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitTime, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}
