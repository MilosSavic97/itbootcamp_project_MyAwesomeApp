package MyAwesomeAppTest;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{

    @Test
    @Description("Test Case 1: Forbids visits to home url if not authenticated")
    public void ForbidsVisitsToHomeNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/home");
        checkUrl("/login");
    }
    @Test
    @Description("Test Case #2: Forbids visits to profile url if not authenticated\n")
    public void ForbidsVisitsToProfileNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/profile");
        checkUrl("/login");
    }
    @Test
    @Description("Test Case #3: Forbids visits to admin cities url if not authenticated\n")
    public void ForbidsVisitsToAdminCitiesNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/cities");
        checkUrl("/login");
    }
    @Test
    @Description("Test Case #4: Forbids visits to admin users url if not authenticated\n")
    public void ForbidsVisitsToAdminUsersNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/users");
        checkUrl("/login");
    }


}


