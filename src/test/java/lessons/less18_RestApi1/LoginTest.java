package lessons.less18_RestApi1;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

//https://reqres.in/
//"email": "eve.holt@reqres.in", "password": "cityslicka"
public class LoginTest {

    @Test
    void successLoginTest(){
        String authData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}"; //BAD PRACTICE

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
//                .header("Content-type", "text/json")
                .body(authData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void missingPasswordTest(){
        String authData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"\"}"; //BAD PRACTICE

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(authData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

    @Test
    void missingEmailTest(){
        String authData = "{\"email\": \"\", \"password\": \"cityslicka\"}";

        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(authData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }

    @Test
    void negativeLoginTest400(){
        String authData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}"; //BAD PRACTICE

        given()
                .log().uri()
                .log().method()
                .log().body()
                .body(authData)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing email or username"));
    }
}
