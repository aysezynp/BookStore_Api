@wip
  Feature: BookStore flow

    Scenario: Test-1
      When Get all books
      Then Validate that all books are listed

    Scenario: Test-2
      When Add New User
      Then Validate that the new user is posted

    Scenario: Test-3
      When Generate Token
      Then Validate that the token is generated

    Scenario: Test-4
        When Authorize User
        Then Validate that the user is authorized

    Scenario: Test-5
      When Assign a new book to the user
      Then Validate that the book is assigned to the user

    Scenario: Test-6
      When Update an existing book
      Then Validate that the book is updated
      
    Scenario: Test-7
      When Delete an existing book
      Then Validate that the book is removed

