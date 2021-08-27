package com.example.employeeTDD.demo.BDD_Cucumber_Tests;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        snippets = SnippetType.CAMELCASE,
        features = {"classpath:features"}
)
public class CucumberTest {
    public CucumberTest() {

    }
}
