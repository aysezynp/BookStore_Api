package com.bookstore.services;

import com.bookstore.utilities.Globals;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.*;

public class AddNewUser extends Globals {
    Faker faker=new Faker();

    public void addNewUser(){

        username=faker.name().username();
        password="Abcd.!123"+faker.internet().password();

        Map<String,Object>map=new HashMap<>();
        map.put("userName",username);
        map.put("password",password);

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(map).log().all()
                .post("/Account/v1/User")
                .prettyPeek();
    }
    public void validateThatUserPosted(){

        //get userId from the response body
        userId=response.path("userID");

        //verify status code is 201
        Assert.assertEquals(response.statusCode(),201);

        //verify that username is correct
        Assert.assertEquals(username,response.path("username"));
    }
}
