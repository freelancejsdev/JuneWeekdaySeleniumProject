import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/"},
       // glue = {"steps"}
      //  tags = "@regression", // one tag
        //tags = "@regression or @ui",
        // dryRun = true,
         monochrome = true,


        plugin = {"pretty","html:target/report.html"},
       // tags = "@new and @ui"
        tags = "@regression"

)



public class TestRunner
{

}
