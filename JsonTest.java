package jsonAPITest;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;

public class JsonTest {
    @Test
    public void postGet(){
        Response response = given()
                .when()
                .get("http://localhost:3000/posts");
             response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);

    }
    @Test
    public void postUpdate(){

        ValidatableResponse response=given()
                .accept("application/json")
               .body(" {\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"title\": \"Api testing\",\n" +
                        "      \"author\": \"Rajkumar Patil\"\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/posts/1")
                .then().assertThat().statusCode(200);


    }

@Test
    public void postDelete(){
        Response response=given()
                .accept("application/json")
                .body(" {\n" +
                        "      \"id\": \"3\",\n" +
                        "      \"title\": \"Api testing and Manual testing\",\n" +
                        "      \"author\": \"Rajkumar\"\n" +
                        "    }")
                .when()
                .delete("http://localhost:3000/posts/3");
        response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 200);

}
@Test
    public void postPost(){
        Response response=given()
                .accept("application/json")
            .body(" {\n" +
                    "      \"id\": \"3\",\n" +
                    "      \"title\": \"Api testing and Manual testing\",\n" +
                    "      \"author\": \"Rajkumar\"\n" +
                    "    }")
            .when()
                .post("http://localhost:3000/posts");
        response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 201);

}

@Test
    public void commentGet(){
    Response response=given()
            .header("Content-Type", "application/json")
            .when()
            .get("http://localhost:3000/comments");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 200);

}
@Test
    public void commentPost(){
        Response response=given()
                .header("Content-Type", "application/json")
                .body("   {\n" +
                        "        \"id\": \"2\",\n" +
                        "        \"body\": \"some comment are changed and posting something\",\n" +
                        "        \"postId\": 2\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 201);

}
@Test
    public void commentDelete(){
    Response response=given()
            .accept("application/json")
            .header("Content-Type", "application/json")
            .body(" {\n" +
                    "        \"id\": \"2\",\n" +
                    "        \"body\": \"some comment are changed and posting something\",\n" +
                    "        \"postId\": 2\n" +
                    "    }")
            .when()
            .delete("http://localhost:3000/comments/2");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 200);


}
@Test
    public void commentPut(){
    Response response=given()
            .accept("application/json")
            .header("Content-Type", "application/json")
            .body(" {\n" +
                    "      \"id\": \"1\",\n" +
                    "      \"body\": \"some comment are changed\",\n" +
                    "      \"postId\": 1\n" +
                    "    }")
            .when()
            .delete("http://localhost:3000/comments/1");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 404);


}

@Test

    public void profileGet(){
    Response response = given()
            .when()
            .get("http://localhost:3000/profile");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 200);

}
@Test
    public void profilePost(){
    Response response=given()
            .header("Content-Type", "application/json")
            .body("   {{\n" +
                    "    \"name\": \"Darshan\"\n" +
                    "}\n")
            .when()
            .post("http://localhost:3000/profile");
    response.prettyPrint();
}
@Test
    public void profileDelete(){
    Response response=given()
            .accept("application/json")
            .body(" {\n" +
                    "    \"name\": \"Rajkumar Patil\"\n" +
                    "}")
            .when()
            .delete("http://localhost:3000/profile/1");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 404);

}
@Test
    public void profilePut(){
    Response response=given()
            .accept("application/json")
            .header("Content-Type", "application/json")
            .body(" {\n" +
                    "    \"name\": \"Rajkumar Patil\"\n" +
                    "}")
            .when()
            .delete("http://localhost:3000/profile");
    response.prettyPrint();
    Assert.assertEquals(response.statusCode(), 404);
}

}
