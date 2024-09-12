package api.test;

import api.endpoints.Authendpoints;
import api.endpoints.booksendpoints;
import api.payload.Pojo;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static api.endpoints.Authendpoints.createtokenEndpoints;

public class booksTest {


    Faker faker;
    Pojo paylod;





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


}
