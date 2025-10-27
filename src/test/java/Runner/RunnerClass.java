package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		       
		features=".//feature/features.feature",
		glue="AllSteps",
		dryRun=false,
		monochrome=true,
		tags="@Tag1",
		plugin= {"pretty","html:target/Reports/report1.html"}
		
		
		)




public class RunnerClass {

}
