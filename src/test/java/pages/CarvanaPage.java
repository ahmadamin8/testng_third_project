package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaPage {
    public CarvanaPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='Logo__LogoWrapper-sc-14r2405-0 fSZhVx']/*/*")
    public WebElement carvanaLogo;

    @FindBy(xpath = "//div[@data-qa='menu-wrapper']")
    public List<WebElement> navigationItems;

    @FindBy(xpath = "//div[@data-qa='account-modal-tab-wrapper']")
    public WebElement signInModal;

    @FindBy(xpath = "//a[@data-cv-test='headerSignInLink']")
    public WebElement firstSignInButton;

    @FindBy(id = "usernameField")
    public WebElement emailBox;

    @FindBy(id = "passwordField")
    public WebElement passWordBox;

    @FindBy(xpath = "//button[@data-cv='sign-in-submit']")
    public WebElement secondSignInButton;

    @FindBy(xpath = "//div[@data-qa='error-message-container']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@data-qa='header-items']/*")
    public WebElement searchCarsLink;

    @FindBy(xpath = "//input[@data-qa='search-bar-input']")
    public WebElement searchInputBox;

    @FindBy(xpath = "//button[@data-qa='go-button']")
    public WebElement goButton;

    @FindBy(xpath = "//button[@data-qa='drop-down-wrap']")
    public List<WebElement> filterOptions;

    @FindBy(css = ".result-tile picture")
    public List<WebElement> images;

    @FindBy(className = "favorite-vehicle")
    public List<WebElement> favButton;

    @FindBy(css = "div[data-test='InventoryTypeExperiment']")
    public List<WebElement> inventory;

    @FindBy(className = "year-make")
    public List<WebElement> yearAndMake;

    @FindBy(className = "trim-mileage")
    public List<WebElement> mileage;

    @FindBy(className = "upgrades-price")
    public List<WebElement> price;

    @FindBy(className = "monthly-payment")
    public List<WebElement> monthlyPayments;

    @FindBy(className = "down-payment")
    public List<WebElement> downPayments;

    @FindBy(className = "delivery-chip")
    public List<WebElement> deliveryChip;

}
