package MyAwesomeAppsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNameInput(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.xpath("//input[@id='confirmPassword']"));
    }
    public WebElement getSignMeUpButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));

    }
    public WebElement emailAlreadyExistsError() {
        return driver.findElement(By.xpath("//div[@class='v-snack__content']/ul/li"));
    }

    public WebElement getVerifyAccountPopUp(){
        return driver.findElement
                (By.xpath("//div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']"));
    }
    public WebElement getVerifyAccountPopUpCloseButton(){
        return driver.findElement
                (By.xpath("//div[@class='v-card__actions']/button"));
    }
    public void isPopUpVisible(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@role='status']"))));
    }



}
