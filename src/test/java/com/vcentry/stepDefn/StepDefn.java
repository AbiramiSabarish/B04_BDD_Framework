package com.vcentry.stepDefn;

import org.junit.Assert;

import com.vcentry.base.BaseClass;
import com.vcentry.pages.FormPage;
import com.vcentry.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefn extends BaseClass{
	
	LoginPage login;
	FormPage form;
	
	@Given("User Navigate to {string} in {string} browser")
	public void user_navigate_to_browser(String page, String browser) {
	    initilize(browser);
	    launchUrl(getProp(page));
	    login=new LoginPage(driver);
	    form=new FormPage(driver);
	}
	@Given("User enter username as {string}")
	public void user_enter_username_as(String username) {
	    login.enterUsername(username);
	}
	@Given("User enter password as {string}")
	public void user_enter_password_as(String pwd) {
	    login.enterPwd(pwd);
	}
	@When("User click on login button")
	public void user_click_on_login_button() {
	   login.clickLogin();
	}
	@Then("Validate user navigated to Homepage")
	public void validate_user_navigated_to_homepage() {
	    login.verifyLogin();
	}
	
	@Then("Validate the error message {string}")
    public void validate_error_msg(String msg) {
		login.verifyLoginError(msg);
	}
	
	@Given("User enter {string} as {string}")
	public void user_enter_as(String field, String value) {
	    switch (field) {
		case "ProductName":
			form.enterProdName(value);
			break;
		case "MobNum":
			form.enterMobNum(value);
			break;
		case "EmailId":
			form.enterEmail(value);
			break;
		case "Quantity":
			form.enterProdQty(value);
			break;
		case "purchaserName":
			form.enterPurNam(value);
			break;

		default:
			Assert.assertEquals("Valid Field", "Invalid Field");
			break;
		}
	}
	@Given("Select Product ctg  as {string}")
	public void select_product_ctg_as(String ctg) {
	    form.selectProdCtg(ctg);
	}
	@Given("Select GST applied as {string}")
	public void select_gst_applied_as(String gst) {
	   form.selectGst(gst);
	}
	@Given("Select Available payment as {string}")
	public void select_available_payment_as(String payment) {
	   form.selectPayment(payment);
	}
	@When("User click on place order")
	public void user_click_on_place_order() {
	   form.placeOrder();
	}
	@Then("User gets order placed message as {string}")
	public void user_gets_order_placed_message(String msg) {
	    form.verifyOrderPlaced(msg);
	}

}
