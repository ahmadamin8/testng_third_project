package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base{

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testHomePageAndURL(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void testCarvanaLogo(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaPage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testNavigationItems(){
        driver.get("https://www.carvana.com/");
        String[] navigationSectionItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(carvanaPage.navigationItems.get(i).getText(), navigationSectionItems[i]);
        }
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInErrorMessage(){
        driver.get("https://www.carvana.com/");
        carvanaPage.firstSignInButton.click();
        Assert.assertTrue(carvanaPage.signInModal.isDisplayed());
        carvanaPage.emailBox.sendKeys("johndoe@gmail.com");
        carvanaPage.passWordBox.sendKeys("abcd1234");
        carvanaPage.secondSignInButton.click();
        Assert.assertEquals(carvanaPage.errorMessage.getText(), "Email address and/or password combination is incorrect\n" +
                "Please try again or reset your password.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilterAndButton(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        carvanaPage.searchCarsLink.click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars");
        String[] allFilterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(carvanaPage.filterOptions.get(i).getText(), allFilterOptions[i]);
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTiles(){
        driver.get("https://www.carvana.com/");
        Waiter.pause(2);
        carvanaPage.searchCarsLink.click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars");
        carvanaPage.searchInputBox.sendKeys("mercedes-benz");
        carvanaPage.goButton.click();
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.carvana.com/cars/mercedes-benz?email-capture=");

        for(WebElement element : carvanaPage.images){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.favButton){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.inventory){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.yearAndMake){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.mileage){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.price){
            Assert.assertTrue(Integer.parseInt(element.getText().replaceAll("[\\D]", "")) > 0);
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.monthlyPayments){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.downPayments){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }

        for(WebElement element : carvanaPage.deliveryChip){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertNotNull(element.getText());
        }
    }
}
