Feature: Do a Google search

  Scenario: Search returns correct result
    Given user has access to Google Search
    When user search for "Google Headquarters"
    Then search returns with an expanded box
    And location is showing as "Mountain View, California, United States"