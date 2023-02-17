package MyAwesomeAppTest;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{


    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitAdminCitiesPage() throws InterruptedException {
        navPagee.getChangeTheme().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        checkUrl("/admin/cities");
    }

    @Test(priority = 20)
    @Description("Test #2:  Checks input types for create/edit new city")
    public void checkInputTypesForCreateEditCity() throws InterruptedException {
       /* navPagee.getChangeTheme().click();
        navPagee.getSignupTopButton().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");      //LOGIN FRIST If running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.verifyEditDialogDisplayed();
        Assert.assertTrue(citiesPage.getInputNewItemDialog().getAttribute("type").equals("text"));

    }
    @Test(priority = 30)
    @Description("Test #3:  Create new city")
    public void createNewCity() throws InterruptedException {
        //navPagee.getChangeTheme().click();
        /*navPagee.getSignupTopButton().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");     //LOGIN FRIST If running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        citiesPage.getNewItemButton().click();
        citiesPage.getInputNewItemDialog().sendKeys("Belgrade");
        citiesPage.getSaveButtonNewItemDialog().click();
        messagePopUpPage.isPopUpVisible();
        messagePopUpPage.waitProgressBarInvisible();
        Assert.assertTrue(messagePopUpPage.getPopUpStaus().getText().contains("Saved "));


    }
    @Test(priority = 40)
    @Description("Test #4:  Edit City")
    public void editCity() throws InterruptedException {
        //navPagee.getChangeTheme().click();
        /*navPagee.getSignupTopButton().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");     //LOGIN FRIST If running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        citiesPage.getSearchBar().sendKeys("Belgrade");
        citiesPage.verifyNumberOfRows(1);
        citiesPage.getEditButtonByRow(1).click();
        citiesPage.getInputEditDialog().click();
        citiesPage.deleteFromInput();
        citiesPage.getInputEditDialog().clear();
        citiesPage.getInputEditDialog().sendKeys("Nis");
        citiesPage.getSaveButtonNewItemDialog().click();
        messagePopUpPage.isPopUpVisible();
        messagePopUpPage.waitProgressBarInvisible();
        Assert.assertTrue(messagePopUpPage.getPopUpStaus().getText().contains("Saved "));
    }
    @Test(priority = 50)
    @Description("Test #5:  Search City")
    public void searchCity() throws InterruptedException {
        /*navPagee.getChangeTheme().click();
        navPagee.getSignupTopButton().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");     //LOGIN FRIST If running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        citiesPage.getSearchBar().sendKeys("Nis");
        Assert.assertTrue(citiesPage.selectCell(1, 2).getText().contains("Nis"));

    }
    @Test(priority = 60)
    @Description("Test #6:  Delete City")
    public void deleteCity() throws InterruptedException {
        /*navPagee.getChangeTheme().click();
        navPagee.getSignupTopButton().click();
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");     //LOGIN FRIST If running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.getAdminLinkTopButton().click();
        navPagee.getCitiesFromAdminButton().click();
        citiesPage.getSearchBar().sendKeys("Nis");
        Thread.sleep(1000);
        Assert.assertTrue(citiesPage.selectCell(1, 2).getText().contains("Nis"));
        citiesPage.getDeleteButtonByRow(1).click();
        citiesPage.getDialogDeleteButton().click();
        messagePopUpPage.isPopUpVisible();
        messagePopUpPage.waitProgressBarInvisible();
        Thread.sleep(1000);
        Assert.assertTrue(messagePopUpPage.getPopUpStaus().getText().contains("Deleted "));
    }

}




