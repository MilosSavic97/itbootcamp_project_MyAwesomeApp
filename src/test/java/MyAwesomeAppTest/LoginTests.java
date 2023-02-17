package MyAwesomeAppTest;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test (priority = 10)
    @Description("Test Case 1: Visits the login page")
    public void visitLoginPage() throws InterruptedException {
        navPagee.getChangeTheme().click();
        //navPagee.setLanguage("EN");
        navPagee.getLoginTopButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"), "Wrong url, /login is not showing");

    }

    @Test(priority = 20)
    @Description("Test Case 2: Checks input types")
    public void checkInputTypes() throws InterruptedException {
        navPagee.getLoginTopButton().click();
        Assert.assertEquals(loginPage.getLoginPageEmailInput().getAttribute
                ("type"),
                "email",
                "Wrong type of attribute");

        Assert.assertEquals(loginPage.getLoginPagePasswordInput().getAttribute
                        ("type"),
                "password",
                "Wrong type of attribute");
    }

    @Test(priority = 30)
    @Description("Test Case 3: Displays errors when user does not exist")
    public void displayErrorUserDoesNotExist() throws InterruptedException {
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getLoginPagePasswordInput().sendKeys("password123");
        loginPage.getLoginPageLoginButton().click();
        messagePopUpPage.verifyPopUpErrorDisplayed();
        Assert.assertEquals(messagePopUpPage.userDoesNotExistError().getText(),
                "User does not exists",
                "Wrong error message/ should be /user does not exist/");
    }
    @Test(priority = 40)
    @Description("Test Case 4: Displays errors when password is wrong")
    public void displayErrorPasswordWrong() throws InterruptedException {
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");
        loginPage.getLoginPagePasswordInput().sendKeys("password123");
        loginPage.getLoginPageLoginButton().click();
        messagePopUpPage.verifyPopUpErrorDisplayed();
        Assert.assertEquals(messagePopUpPage.wrongPasswordError().getText(),
                "Wrong password",
                "Wrong error message/ should be /wrong password/");
    }

    @Test(priority = 50)
    @Description("Test Case 5: Successful login")
    public void loginOnPage() throws InterruptedException {
        navPagee.getLoginTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com");
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();
        checkUrl("/home");
    }

    @Test(priority = 60)
    @Description("Test Case 6: Logout")
    public void logout() throws InterruptedException {
        //navPagee.getChangeTheme().click();
        /*navPagee.getLogoutTopButton().click();
        loginPage.getLoginPageEmailInput().sendKeys("admin@admin.com"); //Login if running single test
        loginPage.getLoginPagePasswordInput().sendKeys("12345");
        loginPage.getLoginPageLoginButton().click();*/
        navPagee.verifyVisibilityOfLogOutButton();
        navPagee.getLogoutTopButton().click();

    }


}
