import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.Matchers.containsString;

public class LoggingTest extends AbstractTest{
    @BeforeAll
    static void setUp(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test//получилось авторизоваться
    public void getDataTest() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("ElenaPertseva", "6e29e49995").headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);


    }
    @Test
    void postTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")

                .when()
                .contentType(ContentType.JSON)
                .post("https://test-stand.gb.ru/login")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void secondPostTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva87", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("Username", "ElenaPertseva87")
                .when()
                .contentType(ContentType.JSON)
                .post("https://test-stand.gb.ru/login")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test
    void thirdPostTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "")
                .headers("X-Auth-Token", "a759ce0fc315a3d86e29e4999522222bc22b98a876bb25e")
                .queryParam("Password", "6e29e4999522222")

                .when()
                .contentType(ContentType.JSON)
                .post("https://test-stand.gb.ru/login")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void fourthPostTest(){
        RestAssured.given()
                .log().all()
                .headers("X-Auth-Token", "a759ce0fc315a3d86e29e4999522222bc22b98a876bb25e")
                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()

                .statusCode(401)
                .statusLine("HTTP/1.1 401 Unauthorized")
                .statusLine(containsString("HTTP/1.1 401 Unauthorized"));

    }

}

