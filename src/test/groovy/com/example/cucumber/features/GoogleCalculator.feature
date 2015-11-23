Feature: Do a Google calculation

  Scenario Outline: Calculator shows correct result
    Given user has access to Google Calculator
    When user input "<firstOperand>", "<operator>", "<secondOperand>"
    Then result "<result>" is displayed

    Examples:
      | firstOperand | operator | secondOperand | result |
      | 9            | +        | 3             | 12     |
      | 9            | -        | 3             | 6      |
      | 9            | *        | 3             | 27     |
      | 9            | /        | 3             | 3      |