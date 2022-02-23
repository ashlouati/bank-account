Feature: Print
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

  Scenario: Print a deposit statement line
    Given A new account with an empty balance
    When I deposit an amount of 3275
    When I print the statement
    Then Console should print the following
      | OPERATION | DATE   | AMOUNT | BALANCE |
      | DEPOSIT | 23/02/2022 19:43 | 3275 | 3275 |

  Scenario: Print a deposit and withdrawal statement lines
    Given A new account with an empty balance
    When I deposit an amount of 4000
    When I withdraw an amount of 2900
    When I print the statement
    Then Console should print the following
      | OPERATION | DATE | AMOUNT | BALANCE |
      | DEPOSIT | 23/02/2022 19:43 | 4000 | 4000 |
      | WITHDRAWAL | 23/02/2022 19:43 | 2900 | 1100 |