package MyAwesomeAppsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage{


    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void visibilityOfVerifyAccountPopUp(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//div[@class='v-card__title headline grey lighten-2 black--text dlgVerifyAccount']/i"))));
    }
    public WebElement getPopUpStaus(){
        return driver.findElement(By.xpath("//div[2]/div/div[3]/div/div/div/div/div[1]"));
    }
    public void isPopUpVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("v-snack__content")));
    }
    public String getSavedSuccessfullyMessage(){
        String x = driver.findElement(By.className("//div[@role='status']/../..")).getText();
        return x;
    }
    public void verifyPopUpErrorDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='v-snack__content']"))));
    }
    public WebElement userDoesNotExistError() {
        return driver.findElement(By.xpath("//div[@class='v-snack__content']/ul/li"));
    }
    public WebElement wrongPasswordError(){
        return driver.findElement(By.xpath("//div[@class='v-snack__content']/ul/li"));
    }

    public void waitProgressBarInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@role='progressbar']"))));
    }

}
