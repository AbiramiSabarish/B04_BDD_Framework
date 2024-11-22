package com.vcentry.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vcentry.base.BaseClass;

public class FormPage extends BaseClass{
	WebDriver driver;
	
	public FormPage(WebDriver wd) {
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	  @FindBy(id="id0")
		private WebElement prodName;
	    
	    @FindBy(id="id1")
		private WebElement mobNum;
	    
	    @FindBy(id="id2")
		private WebElement email;
	    @FindBy(id="id3")
		private WebElement prodCtg;
	    @FindBy(id="id4")
		private WebElement prodQty;
	    @FindBy(id="id5")
		private WebElement purName;
	    @FindBy(id="idno")
		private WebElement gstNo;
	    @FindBy(id="idyes")
		private WebElement gstYes;
	    @FindBy(id="cod")
		private WebElement cod;
	    @FindBy(id="netbank")
		private WebElement netBk;
	    @FindBy(id="order")
		private WebElement orderBtn;
	    @FindBy(xpath="//div[@class='alert alert-success']")
		private WebElement sucessMsg;

	
	public void enterProdName(String productName) {
		enterText(prodName, productName);
	}
	
	public void enterMobNum(String number) {
		enterText(mobNum, number);
	}
	
	public void enterEmail(String emailId) {
		enterText(email, emailId);
	}
	
	public void selectProdCtg(String ctg) {
		selectByText(prodCtg, ctg);
	}
	
	public void enterProdQty(String quantity) {
		enterText(prodQty, quantity);
	}
	
	public void enterPurNam(String purchaserName) {
		enterText(purName, purchaserName);
	}
	
	public void selectGst(String gst) {
		if(gst.equalsIgnoreCase("Yes")) {
			clickElement(gstYes);
		} else {
			clickElement(gstNo);

		}
	}
	
	public void selectPayment(String payment) {
		if(payment.equalsIgnoreCase("cod")) {
			selectCheckBox(cod);
		}else {
			selectCheckBox(netBk);
		}
	}
	
	public void placeOrder() {
		clickElement(orderBtn);
	}
	public void verifyOrderPlaced(String msg) {
		Assert.assertEquals(msg,getText(sucessMsg));
	}
}
			