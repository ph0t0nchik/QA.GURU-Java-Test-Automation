package lessons.less18_RestApi1;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

public class StatusTest {
    /*
    1. Make request to https://selenoid.autotests.cloud/status
    2. Get response {
              "total": 20,
              "used": 0,
              "queued": 0,
              "pending": 0,
              "browsers": { ... }
    3. Check total is 20
    */

    @Test
    void checkTotalMini(){
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(220));
    }

    @Test
    void checkTotal(){
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(20));
    }

    @Test
    void checkTotalWithLogs(){
        given()
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .body("total", is(20));
    }

    @Test
    void checkTotalSomeWithLogs(){
        given()
                .log().uri()
                .log().body()
                .log().method()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .body("total", is(20));
    }

    @Test
    void checkTotalWithStatusCheck(){
        given()
                .log().uri()
                .log().body()
                .log().method()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(20));
    }

    @Test
    void checkTotalWithBrowserCheck(){
        given()
                .log().uri()
                .log().body()
                .log().method()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(20))
                .body("browsers.chrome", hasKey("100.0"));
    }
}
