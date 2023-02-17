package MyAwesomeAppsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLoginPageEmailInput(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    public WebElement getLoginPagePasswordInput(){
        return driver.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement getLoginPageLoginButton(){
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }


}








