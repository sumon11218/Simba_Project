package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)//end of CucumberOptions

public class Runner {
}
