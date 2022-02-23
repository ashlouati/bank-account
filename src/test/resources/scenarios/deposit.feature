Feature: Deposit
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Scenario: Make a deposit of amount 100 in an empty account
    Given A new account with an empty balance
    When I deposit an amount of 100
    Then The balance should exactly be equal to 100

  Scenario: Make a deposit of a negative amount
    Given A new account with an empty balance
    When I deposit an amount of -200.00
    Then The deposit should be rejected
    Then The balance should exactly be equal to 0