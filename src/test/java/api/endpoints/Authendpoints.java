package api.endpoints;

import api.payload.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authendpoints {


    public static Response createtokenEndpoints(Pojo payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Roots.CreateToken);
        return response;

    }
}
