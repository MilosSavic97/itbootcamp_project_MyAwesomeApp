package MyAwesomeAppsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPagee extends BasePage{
    public NavPagee(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLinkTopButton(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a"));
    }
    public WebElement getAboutLinkTopButton(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[2]"));
    }
    public WebElement getMyProfileTopButton(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[3]"));
    }
    public WebElement getAdminLinkTopButton(){
        return driver.findElement(By.xpath
                ("//button[@class='btnAdmin hidden-sm-and-down v-btn v-btn--text theme--dark v-size--default']"));
    }
    public WebElement getCitiesFromAdminButton(){
        return driver.findElement(By.xpath
                ("//div[@class='v-list v-sheet theme--dark']/a[@class='v-list-item v-list-item--link theme--dark btnAdminCities']"));
    }
    public WebElement getUsersFromAdminButton(){
        return driver.findElement(By.xpath
                ("//div[@class='v-list v-sheet theme--dark']/a[@class='v-list-item v-list-item--link theme--dark btnAdminUsers']"));
    }
    public WebElement getLoginTopButton(){
        return driver.findElement(By.xpath
                ("//a[@href='/login']"));
    }

    public WebElement getSignupTopButton(){
        return driver.findElement
                (By.xpath("//a[@href='/signup']"));
    }
    public WebElement getLogoutTopDarkThemeButton(){
        return driver.findElement(By.xpath
                ("//button[@class='hidden-sm-and-down btnLogout v-btn v-btn--text theme--dark v-size--default']"));
    }
    public WebElement getLogoutTopButton(){
        return driver.findElement(By.xpath
                ("//button[@class='hidden-sm-and-down btnLogout v-btn v-btn--text theme--dark v-size--default']"));
    }
    public WebElement getLanguagesTopButton(){
        return driver.findElement(By.xpath
                ("//button[@class='btnLocaleActivation v-btn v-btn--text theme--light v-size--default']"));
    }
    public WebElement getLanguagesTopDarkThemeButton(){
        return driver.findElement(By.xpath
                ("//button[@class='btnLocaleActivation v-btn v-btn--text theme--dark v-size--default']"));
    }
    public void setLanguage(String lan) {
        this.getLanguagesTopButton().click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath
                ("//div[@class='v-menu__content theme--light menuable__content__active']"))));
        driver.findElement(By.xpath
                ("//div[@class='v-list-item v-list-item--link theme--light btn"+lan+"']" )).click();

    }

    public WebElement getENlanguage() {
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnEN']"));
    }
    public WebElement getESlanguage() {
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnES']"));
    }
    public WebElement getFRlanguage() {
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnFR']"));
    }
    public WebElement getCNlanguage() {
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnCN']"));
    }
    public WebElement getUAlanguage() {
        return driver.findElement(By.xpath("//div[@class='v-list-item v-list-item--link theme--light btnUA']"));
    }
    public void verifyVisibilityOfLogOutButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//button[@class='hidden-sm-and-down btnLogout v-btn v-btn--text theme--dark v-size--default']"))));
    }
    public WebElement getH1(){
        return driver.findElement(By.xpath("//h1[@class='display-2 font-weight-bold']"));
    }
    public WebElement getChangeTheme(){
        return driver.findElement(By.xpath("//div[@class='v-input--selection-controls__input']"));
    }
}












