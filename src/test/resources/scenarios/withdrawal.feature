Feature: Withdrawal
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Scenario: Make a deposit of 2200 then a withdrawal of amount 450 from an empty account
    Given A new account with an empty balance
    When I deposit an amount of 2200
    When I withdraw an amount of 450
    Then The balance should exactly be equal to 1750

  Scenario: Try to make a withdrawal exceeding the funds
    Given A new account with an empty balance
    When I deposit an amount of 4300
    When I withdraw an amount of 4300.99
    Then The withdrawal should be rejected
    Then The balance should exactly be equal to 4300