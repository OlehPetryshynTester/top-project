package tests.ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {


    private final SelenideElement userNameField = $("#form-username");
    private final SelenideElement userPasswordField = $("#form-password");
    private final SelenideElement userSingInButton = $(".btn");

    private final SelenideElement alertError = $(".alert");



    public DashboardPage logIn (String userName, String password){
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getUserPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getUserSingInButton().shouldBe(Condition.visible).click();
        return new DashboardPage();
    }


    public LogInPage logInInvalid(String userName, String password){
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getUserPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getUserSingInButton().shouldBe(Condition.visible).click();
        return new LogInPage();
    }


    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getUserPasswordField() {
        return userPasswordField;
    }

    public SelenideElement getUserSingInButton() {
        return userSingInButton;
    }

    public SelenideElement getAlertError() {
        return alertError;
    }
}
