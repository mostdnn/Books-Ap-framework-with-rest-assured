package api.test;

import api.endpoints.Authendpoints;
import api.endpoints.booksendpoints;
import api.endpoints.ordersendpoints;
import api.payload.Pojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthTest {

    Faker faker;
    Pojo paylod;

    public static String orderid;

    public static String accessToken;


    @BeforeTest
    public void setupdata(){
        faker=new Faker();
        paylod=new Pojo();
        paylod.setClientName(faker.name().firstName());
        paylod.setClientEmail(faker.internet().emailAddress());
        paylod.setBookId(faker.number().numberBetween(1,5));
        paylod.setCustomerName(faker.name().firstName());




    }




    @Test
    public  void testAuth(){
        Response response= Authendpoints.createtokenEndpoints(paylod);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
        response.then().extract().response();
        accessToken = response.jsonPath().getString("accessToken");
        System.out.println("Access Token: " + accessToken);

    }

    // books test
    @Test
    public  void getlistofbookstest(){
        Response response= booksendpoints.getalistEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    public  void getfictionbookstest(){
        Response response= booksendpoints.getfictionbooksEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);


    }

    @Test
    public void getnonfictionbookstest(){
        Response response= booksendpoints.getnonfictionbooksEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);


    }

    @Test
    public void getbookswithoverlimittest(){
        Response response= booksendpoints.getbookswithoverlimitEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),400);

    }

    @Test
    public void getasinglebooktest(){

        Response response= booksendpoints.getasinglebookEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

    // orders test
    @Test(priority = 1)
    public void submitordertest(){
        Response response= ordersendpoints.submitorderEndpoints(paylod);
        response.then().log().all();
        response.then().extract().response();
        orderid = response.jsonPath().getString("orderId");
        Assert.assertEquals(response.getStatusCode(),201);


    }

    @Test(priority = 2)
    public void getallorderstest(){
        Response response= ordersendpoints.getallordersEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);


    }


    @Test(priority =3)
    public void updateorderstest(){
        Response response= ordersendpoints.updateorderEndpoints(paylod.getCustomerName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),204);
    }


    @Test(priority =4)
    public void deleteordertest(){
        Response response= ordersendpoints.deleteorderEndpoints();
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),204);
    }

}








