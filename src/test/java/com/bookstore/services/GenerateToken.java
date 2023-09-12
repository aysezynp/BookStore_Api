package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class GenerateToken extends Globals {

    public void generateToken(){
        Map<String,Object>map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .post("/Account/v1/GenerateToken")
                .prettyPeek();
    }
    public void ValidateTokenIsGenerated(){
        //get the token and assign it into a global variable
        token=response.path("token");

        //validate that status code is 200
        Assert.assertEquals(response.statusCode(),200);

        //validate that status and result values are correct
        Assert.assertEquals("Success",response.path("status"));
        Assert.assertEquals("User authorized successfully.",response.path("result"));
    }
}
