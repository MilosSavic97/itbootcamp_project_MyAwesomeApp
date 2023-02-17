package MyAwesomeAppsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CitiesPage extends BasePage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.xpath("//div[@class='text-right']/button"));
    }
    public WebElement getInputNewItemDialog(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement getSearchBar(){
        return  driver.findElement(By.xpath("//input[@id='search']"));
    }
    public WebElement getEditButton(){
        return driver.findElement(By.xpath("//button[@id='edit']"));
    }
    public WebElement getDeleteButton(){
        return driver.findElement(By.xpath("//button[@id='delete']"));
    }
    public void verifyEditDialogDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//div[@class='v-dialog dlgNewEditItem v-dialog--active']"))));
    }
    public void verifyDeleteDialogDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//header[@class='v-sheet theme--dark v-toolbar v-toolbar--dense v-toolbar--flat warning']"))));
    }
    public WebElement getDialogDeleteButton(){
        return driver.findElement
                (By.xpath("//button[@class='v-btn v-btn--text theme--dark v-size--default red--text text--lighten3']"));
    }
    public WebElement getEditButtonEditDialog(){
        return driver.findElement
                (By.xpath("//button[@class='btnSave v-btn v-btn--text theme--dark v-size--default green--text text--lighten3']"));
    }
    public WebElement getInputEditDialog(){
        return driver.findElement(By.xpath("//input[@id='name']"));
    }
    public WebElement getSaveButtonNewItemDialog(){
        return driver.findElement(By.xpath
                ("//button[@class='btnSave v-btn v-btn--text theme--dark v-size--default green--text text--lighten3']"));
    }

    public void verifyNumberOfRows (int x) {
        //List<WebElement> list = driver.findElements(By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr"));
        wait.until(ExpectedConditions.numberOfElementsToBe
                (By.xpath("//div[@class='v-data-table__wrapper']/table/tbody/tr"),1));
    }
    public WebElement selectCell(int row, int data){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+data+"]"));
    }
    public WebElement getEditButtonByRow(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/div/button[@id='edit']"));
    }
    public void deleteFromInput() {
        for (int i = 0; i < 15; i++) {
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Keys.BACK_SPACE);
        }
    }
    public WebElement getDeleteButtonByRow(int row){
        return driver.findElement(By.xpath("//tbody/tr["+row+"]/td/div/button[@id='delete']"));

        }



}
