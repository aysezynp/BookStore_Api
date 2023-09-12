package com.bookstore.services;

import com.bookstore.utilities.Globals;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Assert;

public class AddNewBook extends Globals {

    public void assignNewBook(){
        String requestBody="{\n" +
                "  \"userId\": \""+userId+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+isbnNumbers.get(0)+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        response= RestAssured.given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(requestBody).log().all()
                .when()
                .post("/BookStore/v1/Books")
                .prettyPeek();
    }

    public void validateThatBookIsAssigned(){
        //verify status code
        Assert.assertEquals(response.statusCode(),201);

        //validate that isbn number is as expected
        Assert.assertEquals(isbnNumbers.get(0),response.path("books.isbn[0]"));

    }
}
