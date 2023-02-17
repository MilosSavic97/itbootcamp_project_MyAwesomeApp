package MyAwesomeAppTest;

import MyAwesomeAppsPages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

        protected WebDriverWait wait;
        protected WebDriver driver;
        protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
        protected NavPagee navPagee;
        protected LoginPage loginPage;
        protected SignupPage signUp;
        protected CitiesPage citiesPage;
        protected ChromeOptions options;
        protected MessagePopUpPage messagePopUpPage;



    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("load-extension=C:\\Users\\38165\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ggdpplfehdighdpleoegjefnpefgpgfh\\1.0.10_1");
        this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        navPagee = new NavPagee(driver, wait);
        loginPage = new LoginPage(driver, wait);
        signUp = new SignupPage(driver,wait);
        citiesPage = new CitiesPage(driver,wait);
        messagePopUpPage = new MessagePopUpPage(driver,wait );

    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
    }


    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();}

    public void checkUrl(String partOfUrl){
        wait.until(ExpectedConditions.urlContains(partOfUrl));
        //Assert.assertTrue(driver.getCurrentUrl().contains(partOfUrl));
    }
}

