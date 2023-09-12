package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class UpdateBook extends Globals {

    public void updateExistingBook(){
        Map<String,Object>map=new HashMap<>();
        map.put("userId",userId);
        map.put("isbn",isbnNumbers.get(1));

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(map).log().all()
                .when()
                .put("/Bookstore/v1/Books/"+isbnNumbers.get(0))
                .prettyPeek();
    }
    public void validateThatBookIsUpdated(){
        //verify status code
        Assert.assertEquals(response.statusCode(),200);

        //validate userId
        Assert.assertEquals(userId,response.path("userId"));

        //validate username
        Assert.assertEquals(username,response.path("username"));

        //validate isbn number
        Assert.assertEquals(isbnNumbers.get(1),response.path("books.isbn[0]"));
    }
}
