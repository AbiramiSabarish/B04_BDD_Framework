package com.vcentry.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src\\test\\java\\com.vcentry.features\\",
		glue="com.vcentry.stepDefn",
		monochrome = true,
		tags="@form",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRunner {

}

