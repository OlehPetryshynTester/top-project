package tests.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.api.models.BoardInfo;
import tests.api.steps.BoardApiSteps;
import tests.api.models.Result;

import java.util.List;

public class BoardApiTests {
    @Test
    public void checkBoardApi() {
        BoardApiSteps boardApiSteps = new BoardApiSteps();
        Result<List<BoardInfo>> boardInfoResult = boardApiSteps.getBoardForProject(1);
        Assert.assertTrue(boardInfoResult.getResult().size() > 0, "Board request doesn't contain records");
        System.out.println(boardInfoResult.getResult().get(0).getName());
    }
}

