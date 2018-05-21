package com.interviewtest.cucumber.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/java/com/interviewtest/cucumber/featurefile/Login.feature"},
		glue = {"com.interviewtest.cucumber.stepdefn"},
		dryRun = false,
		monochrome = true
		)
public class UserLogin {

}

