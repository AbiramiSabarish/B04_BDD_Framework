package com.vcentry.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vcentry.base.BaseClass;

public class LoginPage extends BaseClass {
	
	WebDriver driver;
	
	public LoginPage(WebDriver wd) {
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_username")
	private WebElement uName;

	@FindBy(id="id_password")
	private WebElement pwd;
	@FindBy(xpath="//button[@class='btn btn-outline-info']")
	private WebElement loginBtn;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	@FindBy(xpath="//div[contains(@class,'alert alert')]//descendant::li")
	private WebElement error;
	@FindBy(xpath="//a[text()='Log In Again']")
	private WebElement loginLink;

	public void enterUsername(String data) {
		enterText(uName, data);
		
		}

	public void enterPwd(String data) {
		enterText(pwd, data);
	}

	public void clickLogin() {
		clickElement(loginBtn);
		
	}
	public void verifyLogin() {
		Assert.assertEquals(true,elementDisplayed(logou));

	}
	public void clickLogout() {
		clickElement(logout);
		clickElement(loginLink);

	}

	public void verifyLoginError(String expected) {
		String actual =error.getText();
		Assert.assertEquals(expected,actual);

	}
}
