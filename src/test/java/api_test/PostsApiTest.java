package api_test;

import client.PostsApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostsApiTest {

	private final PostsApi postsApi = new PostsApi();
	
	
	@Test
	void testGetPostOne() {
		Response response = postsApi.getPost(1);
		assertThat(response.statusCode(),equalTo(200));
		assertThat(response.jsonPath().getInt("id"),equalTo(1));
		assertThat(response.jsonPath().getInt("userId"),equalTo(1));
		assertThat(response.jsonPath().getString("title"),not(emptyOrNullString()));
		assertThat(response.jsonPath().getString("body"),not(emptyOrNullString()));		
	}
	
	@Test
	void testGetPostTwo() {
		Response response = postsApi.getPost(2);
		assertThat(response.statusCode(),equalTo(200));
		assertThat(response.jsonPath().getInt("id"),equalTo(2));
		assertThat(response.jsonPath().getInt("userId"),equalTo(1));
		assertThat(response.jsonPath().getString("title"),not(emptyOrNullString()));
		assertThat(response.jsonPath().getString("body"),not(emptyOrNullString()));		
	}
	
	@Test
	void testNegativeGetPost() {
		Response response = postsApi.getPost(9999);
		assertThat(response.statusCode(),equalTo(404));
		assertThat(response.jsonPath().getString("id"),emptyOrNullString());
		assertThat(response.jsonPath().getString("userId"),emptyOrNullString());
		assertThat(response.jsonPath().getString("title"),emptyOrNullString());
		assertThat(response.jsonPath().getString("body"),emptyOrNullString());		
	}
	
}
