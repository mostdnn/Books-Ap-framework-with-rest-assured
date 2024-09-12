package api.endpoints;

import api.payload.Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.test.AuthTest.accessToken;
import static api.test.ordersTest.orderid;
import static io.restassured.RestAssured.given;

public class ordersendpoints {

    public static Response submitorderEndpoints(Pojo payload){

        Response response= given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .body(payload)
                .when()
                .post(Roots.orders);
        return response;
    }

    public static Response getallordersEndpoints(){

        Response response= given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(Roots.orders);
        return response;
    }



    public static Response updateorderEndpoints(String payload){
        Response response= given()
                .contentType(ContentType.JSON)
                .pathParam("orderId",orderid)
                .body(payload)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .patch(Roots.updateorder);
        return response;
    }
    public static Response deleteorderEndpoints(int orderid,String accessToken){
        Response response= given()
                .contentType(ContentType.JSON)
                .pathParam("orderId",orderid)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete(Roots.deleteorder);
        return response;
    }




}
