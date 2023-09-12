package com.bookstore.step_defs;

import com.bookstore.services.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookStore_StepDefs {

GetAllBooks getAllBooks=new GetAllBooks();
AddNewUser addNewUser=new AddNewUser();
GenerateToken generateToken=new GenerateToken();
AuthorizeUser authorizeUser=new AuthorizeUser();
AddNewBook addNewBook=new AddNewBook();
UpdateBook updateBook=new UpdateBook();
DeleteBook deleteBook=new DeleteBook();

    @When("Get all books")
    public void get_all_books() {
         getAllBooks.getAllBooks();
    }

    @Then("Validate that all books are listed")
    public void validate_that_all_books_are_listed() {
        getAllBooks.validateThatAllBooksAreListed();
    }

    @When("Add New User")
    public void add_New_User() {
         addNewUser.addNewUser();
    }

    @Then("Validate that the new user is posted")
    public void validate_that_the_new_user_is_posted() {
        addNewUser.validateThatUserPosted();
    }

    @When("Generate Token")
    public void generate_Token() {
        generateToken.generateToken();
    }

    @Then("Validate that the token is generated")
    public void validate_that_the_token_is_generated() {
        generateToken.ValidateTokenIsGenerated();
    }

    @When("Authorize User")
    public void authorize_User() {
        authorizeUser.authorizeUser();
    }

    @Then("Validate that the user is authorized")
    public void validate_that_the_user_is_authorized() {
       authorizeUser.validateUserIsAuthorized();
    }

    @When("Assign a new book to the user")
    public void assign_a_new_book_to_the_user() {
        addNewBook.assignNewBook();
    }

     @Then("Validate that the book is assigned to the user")
     public void validate_that_the_book_is_assigned_to_the_user() {
          addNewBook.validateThatBookIsAssigned();
     }

    @When("Update an existing book")
    public void update_an_existing_book() {
          updateBook.updateExistingBook();
    }

    @Then("Validate that the book is updated")
    public void validate_that_the_book_is_updated() {
           updateBook.validateThatBookIsUpdated();
    }

    @When("Delete an existing book")
    public void delete_an_existing_book() {
        deleteBook.deleteExistingBook();
    }

    @Then("Validate that the book is removed")
    public void validate_that_the_book_is_removed() {
        deleteBook.validateBookIsRemoved();
    }

    }
