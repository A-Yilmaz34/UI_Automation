Feature:Testing Wikipedia search function

 # (Here we have 2 automation cases. First one is positive test (happy path).
 # TC1 searches some keywords and verifies if at least %90 of the results include the keyword) (both titles and text bodies)
 # Second case verifies that providing nothing as an input refreshes the page. This is an example of negative test.

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



