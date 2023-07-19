package tests.ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private final SelenideElement titleDashboard = $(".title");
    private final SelenideElement newProjectButton = $("#main > div > ul > li:nth-child(1) > a");
    private final SelenideElement nameField = $("#form-name");
    private final SelenideElement identifierField = $("#form-identifier");
    private final SelenideElement taskLimitField = $("#form-task_limit");
    private final SelenideElement saveButton = $(".btn");


    public DashboardPage createNewProject(String name, String identifier, String taskLimit){
        getNewProjectButton().click();
        getNameField().shouldBe(Condition.visible).sendKeys(name);
        getIdentifierField().shouldBe(Condition.visible).sendKeys(identifier);
        getTaskLimitField().shouldBe(Condition.visible).sendKeys(taskLimit);
        getSaveButton().click();
        return new DashboardPage();
    }

    public SelenideElement getTitleDashboard() {
        return titleDashboard;
    }

    public SelenideElement getNewProjectButton() {
        return newProjectButton;
    }

    public SelenideElement getNameField() {
        return nameField;
    }

    public SelenideElement getIdentifierField() {
        return identifierField;
    }

    public SelenideElement getTaskLimitField() {
        return taskLimitField;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }
}
