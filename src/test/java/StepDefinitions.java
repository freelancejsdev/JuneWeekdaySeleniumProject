import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class StepDefinitions
{
    String homePageExpectedTitle = "nopCommerce demo store";
    String homePageActualTitle;

   String loginPageExpectedTitle = "nopCommerce demo store. Login";
    String loginPageActualTitle;

      String  registerPageExpectedTitle = "nopCommerce demo store. Register";
      String  registerPageActualTitle;

       String registerExpectedSuccessMsg = "Your registration completed";
       String registerActualSuccessMsg;

    @Given("i navigate to url {string}")
    public void i_navigate_to_url(String url)
    {
       BasePage.homePage.navigateToUrl(url);
    }

    @Then("i should be navigated to home page")
    public void i_should_be_navigated_to_home_page()
    {
       homePageActualTitle = BasePage.homePage.getPageTitle();
        Assertions.assertEquals(homePageExpectedTitle,homePageActualTitle);
    }

    @When("i click on login link from the navbar")
    public void i_click_on_login_link_from_the_navbar()
    {
         BasePage.homePage.clickLoginLink();
    }

    @Then("i should be navigated to login page")
    public void i_should_be_navigated_to_login_page()
    {
        loginPageActualTitle = BasePage.homePage.getPageTitle();
        Assertions.assertEquals(loginPageExpectedTitle,loginPageActualTitle);
    }

    @When("i enter email as {string}")
    public void i_enter_email_as(String email)
    {
        BasePage.loginPage.enterEmail(email);
    }

    @When("i enter password as {string}")
    public void i_enter_password_as(String password)
    {
       BasePage.loginPage.enterPassword(password);
    }

    @When("i click on login button")
    public void i_click_on_login_button()
    {
        BasePage.loginPage.clickLoginBtn();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully()
    {
        BasePage.homePage.verifyLogout();
        BasePage.homePage.clickLogoutLink();

    }


    @When("i click on register link from the navbar")
    public void iClickOnRegisterLinkFromTheNavbar()
    {
        BasePage.homePage.clickRegisterLink();
    }

    @Then("i should be navigated to register page")
    public void iShouldBeNavigatedToRegisterPage()
    {
        registerPageActualTitle = BasePage.homePage.getPageTitle();
        Assertions.assertEquals(registerPageExpectedTitle,registerPageActualTitle);
    }


    @When("i select the gender as female")
    public void iSelectTheGenderAsFemale()
    {
       BasePage.registerPage.clickFemaleRadioButton();
    }

    @When("i enter firstName lastName email password confirmPassword")
    public void i_enter_first_name_last_name_email_password_confirm_password(io.cucumber.datatable.DataTable dataTable) {

        BasePage.registerPage.enterFirstName(dataTable.cell(1,0));
        BasePage.registerPage.enterLastName(dataTable.cell(1,1));
        BasePage.registerPage.enterEmail(dataTable.cell(1,2));
        BasePage.registerPage.enterPassword(dataTable.cell(1,3));
        BasePage.registerPage.enterConfirmPwd(dataTable.cell(1,4));

    }

    @When("i click on register button")
    public void i_click_on_register_button()
    {
       BasePage.registerPage.clickRegisterBtn();
    }

    @Then("i should be registered successfully")
    public void i_should_be_registered_successfully()
    {
        registerActualSuccessMsg =  BasePage.registerPage.getConfMsg();

        Assertions.assertEquals(registerExpectedSuccessMsg,registerActualSuccessMsg);

    }


    @Then("i should see error messages for all the mandatory fields")
    public void iShouldSeeErrorMessagesForAllTheMandatoryFields()
    {
        System.out.println("error messages");

    }
}
