package bdd.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:scenarios/",
        glue = "bdd.steps",
        monochrome = true
)
public class RunAccountTest {
}
