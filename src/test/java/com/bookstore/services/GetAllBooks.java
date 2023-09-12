package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

public class GetAllBooks extends Globals {

    public void getAllBooks(){
        response= RestAssured
                .given().log().all()
                .when()
                .get("/BookStore/v1/Books")
                .prettyPeek();

    }
    public void validateThatAllBooksAreListed(){
        //assert status code
        Assert.assertEquals(response.statusCode(),200);

        //get the data by jsonpathObject
        JsonPath jsonPath=response.jsonPath();
        isbnNumbers=jsonPath.getList("books.isbn");

        //validate that all isbn numbers has value
        isbnNumbers.forEach(n->Assert.assertNotNull(n));



    }
}
