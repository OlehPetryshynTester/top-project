package tests.ui.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.api.steps.UserApiSteps;
import tests.ui.pageobjects.DashboardPage;
import tests.ui.pageobjects.LogInPage;

public class LoginTest extends BaseTest {

    private final static String USERNAME = "user7777";
    private final static String INVAILDNAME = "test";

    private final static String INVAILDPASS = "pass";
    private final static String PASSWORD = "myPassword";
UserApiSteps userApiSteps = new UserApiSteps();

private String userId;

    @BeforeMethod
    public void prepareDataForTest(){
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println((userId));
    }

    @Test
    public void testLogInPositive(){
        new LogInPage()
                .logIn(USERNAME,PASSWORD);
       new DashboardPage().getTitleDashboard().shouldBe(Condition.visible);

    }
    @AfterMethod
    public void removeUserAfterTest(){userApiSteps.deleteUser(userId);}


    @Test
    public void testLogInInvalidUserName(){
        new LogInPage()
                .logInInvalid(INVAILDNAME,PASSWORD)
                .getAlertError().shouldBe(Condition.visible);


    }


    @Test
    public void testLogInInvalidPassword(){
        new LogInPage()
                .logInInvalid(USERNAME,INVAILDPASS)
                .getAlertError().shouldBe(Condition.visible);


    }


}
