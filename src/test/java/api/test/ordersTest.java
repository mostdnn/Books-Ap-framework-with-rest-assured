package api.test;

import api.endpoints.ordersendpoints;
import api.payload.Pojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static api.test.AuthTest.accessToken;

public class ordersTest {

    Faker faker;
    Pojo paylod;
    public static String orderid;



    @BeforeTest
    public void setupdata(){
        faker=new Faker();
        paylod=new Pojo();
        paylod.setBookId(faker.number().numberBetween(1,5));
        paylod.setCustomerName(faker.name().firstName());
    }

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
        Response response= ordersendpoints.deleteorderEndpoints(orderid,accessToken);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),204);
    }

}
