
@paymentTest
Feature: Payment Process

  #positive Scenario
  Scenario: Successful payment
    Given the user has a valid credit card
    When the user attempts to process a payment
    Then the payment should be successful

    #negative Scenarios

  Scenario: Payment with invalid credit card
    Given the user has an invalid credit card
    When the user attempts to process a payment
    Then the payment should fail with an invalid card error

  Scenario: Payment with insufficient balance
    Given the user has a valid credit card but insufficient balance
    When the user attempts to process a payment
    Then the payment should fail with an insufficient balance error

  Scenario: Payment fails due to server error
    Given the user has a valid credit card during a server error
    When the user attempts to process a payment
    Then the payment should fail with a server error

  Scenario: Payment fails due to network error
    Given the user has a valid credit card during a network error
    When the user attempts to process a payment
    Then the payment should fail with a network error

  Scenario: Payment fails due to browser error
    Given the user has a valid credit card during a browser error
    When the user attempts to process a payment
    Then the payment should fail with a browser error