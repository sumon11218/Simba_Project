package Simba_API_Tests;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_test {

    @Test
    public void createBook() {
        JSONObject request = new JSONObject();
        request.put("id", 0);
        request.put("title", "Book 201");
        request.put("description", "test");
        request.put("pageCount", 0);
        request.put("excerpt", "test");
        request.put("publishDate", "2024-04-15T18:32:09.960Z");

        Response response =
                given()
                        .contentType("application/json")
                        .body(request.toJSONString())
                        .when()
                        .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        System.out.println("Post Results: " + response.asString());
    }//end of test 1


    @Test
    public void getBooks() {
        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        System.out.println("Get Results: " + response.asString());
    }//end of test 2
    @Test
    public void createAuthorInformation() {
        JSONObject request = new JSONObject();
        request.put("id", 0);
        request.put("idBook", "Book 201");
        request.put("firstName", "test");
        request.put("lastName", "testLast");

        Response response =
                given()
                        .contentType("application/json")
                        .body(request.toJSONString())
                        .when()
                        .post("https://fakerestapi.azurewebsites.net/api/v1/Books")
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        System.out.println("Post Results: " + response.asString());
    }//end of test 3


    @Test
    public void getAuthorInformation() {
        Response response =
                given()
                        .contentType("application/json")
                        .when()
                        .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
                        .then()
                        .assertThat().statusCode(200)
                        .extract().response();

        System.out.println("Get Results: " + response.asString());
    }//end of test 4



}//end of class