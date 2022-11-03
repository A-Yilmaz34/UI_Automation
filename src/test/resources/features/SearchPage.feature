Feature:Testing search function

  Background:
    Given User navigates to search page

  @smoke @TC1
  Scenario Outline:User enters different search keywords and checks if the results are related. (Happy path)
    When user enters "<keywords>"
    And user clicks the searchButton
    Then user verifies that headers include the "<keywords>"

    Examples:
      | keywords                        |
      | Java                            |
      | World Bank                      |
      | National Basketball Association |
      | C                               |

  @smoke @TC2
  Scenario: User provides no input and verifies the page refreshes (Negative Test)
    When user clicks the searchButton
    Then user verifies the page is the same (refreshes)


