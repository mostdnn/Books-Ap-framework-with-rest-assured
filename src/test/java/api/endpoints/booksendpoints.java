package api.endpoints;

import api.payload.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class booksendpoints {


    public static Response getalistEndpoints(){

        Response response= given()
                .contentType(ContentType.JSON)
                .when()
                .get(Roots.getbooks);
        return response;

    }

    public static Response getfictionbooksEndpoints(){

        Response response= given()
                .contentType(ContentType.JSON)
                .queryParam("type","fiction")
                .when()
                .get(Roots.getbooks);
        return response;

    }

    public static Response getnonfictionbooksEndpoints(){

        Response response= given()
                .contentType(ContentType.JSON)
                .queryParam("type","non-fiction")
                .when()
                .get(Roots.getbooks);
        return response;
    }
    public static Response getbookswithoverlimitEndpoints(){

        Response response= given()
                .contentType(ContentType.JSON)
                .queryParam("limit","25")
                .when()
                .get(Roots.getbooks);
        return response;
    }
    public static Response getasinglebookEndpoints(){
        String bookId = "1";
        Response response= given()
                .contentType(ContentType.JSON)
                .pathParam("bookId", bookId)
                .when()
                .get(Roots.getasinglebook);
        return response;
    }










}
