package com.chase.tests;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"features"}, glue= {"com.chase.stepdefinitions"})
public class TestRunner {
	
}
