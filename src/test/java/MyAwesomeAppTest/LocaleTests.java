package MyAwesomeAppTest;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {
    @Test
    @Description("Test Case #1 - Set locale to ES")
    public void setlocaleES() throws InterruptedException {
        navPagee.setLanguage("ES");
        Assert.assertTrue(navPagee.getH1().getText().contains("Página de aterrizaje"));
    }
    @Test
    @Description("Test Case #2 - Set locale to EN")
    public void setlocaleEN() throws InterruptedException {
        navPagee.setLanguage("EN");
        Assert.assertTrue(navPagee.getH1().getText().contains("Landing"));
    }
    @Test
    @Description("Test Case #3 - Set locale to CN")
    public void setlocaleCN() throws InterruptedException {
        navPagee.setLanguage("CN");
        Assert.assertTrue(navPagee.getH1().getText().contains("首页"));
    }
    @Test
    @Description("Test Case #4 - Set locale to FR")
    public void setlocaleFR() throws InterruptedException {
        navPagee.setLanguage("FR");
        Assert.assertTrue(navPagee.getH1().getText().contains("Page d'atterrissage"));
    }

}