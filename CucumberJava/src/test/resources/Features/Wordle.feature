Feature: Wordle Features

  @smoke
  Scenario: Navigating to Wordle WEB Page a
    Given Chrome Browser is Open
    When Go to the Wordle URL
    Then Should see an Info Pop-up
    And Close the Instructions Pop-up
    Then Should see keyboard and input rows

  @sanity1
  Scenario Outline: Giving a invalid word
    Given Wordle Game Platform is open
    And Try the word "<Word>"
    When Click the enter
    Then Should be a deny pop-up

    Examples: 
      | Word  |
      | ERHAN |

  @sanity
  Scenario Outline: Giving a word includes all wrong letters
    Given Wordle Game Platform is open
    And Try the word "<Word>"
    When Click the enter
    Then All the letters should be wrong status

    Examples: 
      | Word  |
      | WHILE |

  @sanity
  Scenario Outline: 
    Given Wordle Game Platform is open
    And Try the word "<Word>"
    When Click the enter
    Then All the letters should be correct

    Examples: 
      | Word  |
      | FOCUS |
