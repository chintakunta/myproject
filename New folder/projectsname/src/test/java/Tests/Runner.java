package Tests;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\kiranjava\\testing\\New folder\\projectsname\\src\\test\\resources\\kiran\\feature1.feature","E:\\kiranjava\\testing\\New folder\\projectsname\\src\\test\\resources\\kiran\\feature2.feature"},plugin= {"pretty","html:target"},monochrome=true)
public class Runner 
{

}
