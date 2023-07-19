package tests.api.steps;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import tests.api.models.BoardInfo;
import tests.api.models.Result;
import tests.api.models.args.BodyArgs;
import tests.api.models.args.projects.ProjectId;

import java.util.List;
import static tests.api.methods.Boards.GET_BOARD;
import static tests.utils.EnvProperties.API_TOKEN;
import static tests.utils.EnvProperties.API_USERNAME;

public class BoardApiSteps extends BaseApiSteps {
    public Result<List<BoardInfo>> getBoardForProject(Integer projectId) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new ProjectId(projectId))
                .method(GET_BOARD)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return response.as(new TypeRef<Result<List<BoardInfo>>>() {
        });
    }
}
