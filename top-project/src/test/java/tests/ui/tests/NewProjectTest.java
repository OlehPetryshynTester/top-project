package tests.ui.tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import tests.ui.pageobjects.LogInPage;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectTest extends BaseTest {

    private final static String NAME = "admin";
    private final static String PASS = "admin";

    private final static String NAMEPROJECT = "Test Project";
    private final static String IDENTIFIER = "MYPROJECT";
    private final static String TASKLIMIT = "20";


    @Test
    public void createProject(){
        new LogInPage()
                .logIn(NAME,PASS)
                .createNewProject(NAMEPROJECT, IDENTIFIER,TASKLIMIT);
        $("#main > section > div.sidebar-content").shouldBe(Condition.visible);
    }
}
