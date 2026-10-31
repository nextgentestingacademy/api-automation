package client;

import config.ApiConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class PostsApi {

	public Response getPost(int postId) {
		return given()
				.baseUri(ApiConfig.getBaseUri())
			.when()
			 .get("/posts/" + postId);
	}
	
}
