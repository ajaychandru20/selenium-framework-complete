package StepDefinitions;
import io.cucumber.java.en.*;

public class LoginSteps {
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("User on login page");
//        PreRunnerScript preRunnerScript = new PreRunnerScript();
//        preRunnerScript.beforeScenario();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println("User enters valid credentials");
    }

    @Then("user is navigated to the homepage")
    public void user_is_navigated_to_the_homepage() {
        System.out.println("User navigated to homepage");
    }
}
