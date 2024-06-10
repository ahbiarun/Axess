package Luma_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Ax Technology\\Luma\\src\\test\\java\\Axess_Technology\\Luma\\feature\\Luma.feature", glue = "luma_Step")
public class Luma {

}
