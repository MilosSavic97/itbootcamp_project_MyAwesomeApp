package MyAwesomeAppTest;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {
    @Test
    @Description("Test Case 1: Visits the signup page")
    public void visitLoginPage() throws InterruptedException {
        navPagee.getSignupTopButton().click();
        checkUrl("/signup");
    }
    @Test
    @Description("Test Case 2: Checks input types")
    public void checkSignupInputTypes() throws InterruptedException {
        navPagee.getSignupTopButton().click();
        Assert.assertTrue(signUp.getEmailInput().getAttribute
                ("type").equals("email"),
                "Attribute type  does not contain -email");

        Assert.assertTrue(signUp.getPasswordInput().getAttribute
                        ("type").equals("password"),
                "Attribute type  does not contain -password");

        Assert.assertTrue(signUp.getConfirmPasswordInput().getAttribute
                        ("type").equals("password"),
                "Attribute type  does not contain -password");

    }
    @Test
    @Description("Test Case 3: Displays errors when user already exists")
    public void errorWhenUserAlreadyExists() throws InterruptedException {
        navPagee.getSignupTopButton().click();
        checkUrl("/signup");
        signUp.getNameInput().sendKeys("Another User");
        signUp.getEmailInput().sendKeys("admin@admin.com");
        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordInput().sendKeys("12345");
        signUp.getSignMeUpButton().click();
        messagePopUpPage.verifyPopUpErrorDisplayed();
        Assert.assertTrue(signUp.emailAlreadyExistsError().getText().equals("E-mail already exists"), "Wrong error message");
        checkUrl("/signup");

    }
    @Test
    @Description("Test Case 4: Successful SignUp")
    public void signUp() throws InterruptedException {
        navPagee.getSignupTopButton().click();
        signUp.getNameInput().sendKeys("Milos Savic");
        signUp.getEmailInput().sendKeys("milos.savic@itbootcamp.rs");
        signUp.getPasswordInput().sendKeys("12345");
        signUp.getConfirmPasswordInput().sendKeys("12345");
        signUp.getSignMeUpButton().click();
        //navPagee.getHomeLinkTopButton().click();
        messagePopUpPage.visibilityOfVerifyAccountPopUp();
        Assert.assertTrue(signUp.getVerifyAccountPopUp().getText().contains("IMPORTANT: Verify your account"));
        signUp.getVerifyAccountPopUpCloseButton().click();
        navPagee.getLogoutTopButton().click();

    }

}
