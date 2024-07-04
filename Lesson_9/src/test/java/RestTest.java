import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestTest {
    private final static String URL = "https://postman-echo.com";

    @Test
    @Order(1)
    public void getTest() {
        given()
                .contentType(ContentType.JSON)
                .when().get(URL + "/get")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    @Order(2)
    public void getWoopsTest() {
        given()
                .contentType(ContentType.JSON)
                .when().get(URL + "/get?foo1=bar1&foo2=bar2")
                .then().log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    @Order(3)
    public void postRawTextTest() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"test\" : \"value\" }")
                .when().post(URL + "/post")
                .then().log().all()
                .statusCode(200)
                .body("data.test", equalTo("value"));
    }

    @Test
    @Order(4)
    public void postFromDataTest() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "value");
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParams(map)
                .when().post(URL + "/post")
                .then().log().all()
                .statusCode(200)
                .body("form.test", equalTo("value"));
    }

    @Test
    @Order(5)
    public void putTest() {
        given()
                .contentType(ContentType.TEXT)
                .body("Aston")
                .when().put(URL + "/put")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Aston"));
    }

    @Test
    @Order(6)
    public void patchTest() {
        given()
                .contentType(ContentType.TEXT)
                .body("Aston")
                .when().patch(URL + "/patch")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Aston"));
    }

    @Test
    @Order(7)
    public void deleteTest() {
        given()
                .contentType(ContentType.TEXT)
                .body("Aston")
                .when().delete(URL + "/delete")
                .then().log().all()
                .statusCode(200)
                .body("data", equalTo("Aston"));
    }
}
