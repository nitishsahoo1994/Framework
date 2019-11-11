package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {

	  @FindBy(name="username")
	  WebElement username;
	  
	  @FindBy(name="pwd")
	  WebElement password;
	  
	  @FindBy(xpath = "//a[@id='loginButton']")
	  WebElement login;
	  
	  public LoginPage() {
		  PageFactory.initElements(driver, this);
	  }
	  
	  public  String loginTite() {
		return driver.getTitle();
	}
}
