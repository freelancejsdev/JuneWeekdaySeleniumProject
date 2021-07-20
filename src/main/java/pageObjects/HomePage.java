package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{

  WebDriver driver;
  WebDriverWait wait;


    //locators

    @FindBy(linkText = "Register") public WebElement registerLink;

    @FindBy(linkText = "Log in") public WebElement loginLink;

    @FindBy(id="small-searchterms") public WebElement searchTextbox;

    @FindBy(className = "search-box-button") public WebElement searchButton;

    @FindBy(className = "ico-logout") public WebElement logoutLink;



    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //actions

    public void clickRegisterLink()
    {
        registerLink.click();
    }

    public void clickLoginLink()
    {
        loginLink.click();

    }

    public void enterSearchItem(String product)
    {
        searchTextbox.sendKeys(product);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }


    public String getPageTitle()
    {
       return driver.getTitle();
    }


    public void clickLogoutLink()
    {
        wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
        logoutLink.click();
    }

    public boolean verifyLogout()
    {
       return logoutLink.isDisplayed();
    }


    public  void navigateToUrl(String url)
    {
       driver.navigate().to(url);
    }















}
