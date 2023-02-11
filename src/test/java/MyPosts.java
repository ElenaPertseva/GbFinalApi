import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyPosts extends AbstractTest{
    @Test//получилось авторизоваться
    public void getDataTest() {
        RequestSpecification httpRequest = RestAssured.given().auth().basic("ElenaPertseva", "6e29e49995").headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e");
        Response res = httpRequest.get("https://test-stand.gb.ru/api/posts");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);

    }
    @Test
    void getOneTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?sort=createdAt&order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void getTwoTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "2")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test
    void getThreeTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("order", "DESC")
                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }
    @Test
    void getFourTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("order", "ASC")
                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));
    }

    @Test
    void getFiveTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "100000")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void getSixTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "100000")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void getSevenTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "1")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void getEightTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("page", "10")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt&order=ASC")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }
    @Test
    void getNineTest(){
        RestAssured.given()
                .log().all()
                .auth().basic("ElenaPertseva", "6e29e49995")
                .headers("X-Auth-Token", "a759ce0fc315a3d8bc22b98a876bb25e")
                .queryParam("order", "DESC")

                .when()
                .contentType(ContentType.JSON)
                .get("https://test-stand.gb.ru/api/posts?owner=notMe&sort=createdAt")

                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .statusLine(containsString("OK"));

    }

}
