package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    publish=false,
    tags= "not @ignoere and not @debug",
    features= {
        "src/test/features"
    },
    glue={
        "stepDefinations"
    },
    plugin={
        "pretty", "html:target/report.html"
    }
)

public class CucumberRunnerTest{

}