
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"org.example.src.test.screens"},
        plugin = { "pretty", "html:target/cucumber-reports" }
)
public class CucumberRunner {
}