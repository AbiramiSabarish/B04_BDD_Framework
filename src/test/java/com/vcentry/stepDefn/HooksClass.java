package com.vcentry.stepDefn;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vcentry.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {

	@After
	public void afterScenarioCloseBrowser() {
		driver.quit();
	}
	
	@AfterStep
	public void afterStep(Scenario s) {
		if (s.isFailed()) {
			final byte[] scn=((TakesScreenshot)driver)
					.getScreenshotAs(OutputType.BYTES);
			s.attach(scn,"image/png","image");	
		}
	}

}
