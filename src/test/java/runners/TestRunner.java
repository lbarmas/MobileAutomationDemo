package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", glue = "stepdefinitions",
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true,
        tags = "@LoginAddProductsToCart")

public class TestRunner extends AbstractTestNGCucumberTests {

}

