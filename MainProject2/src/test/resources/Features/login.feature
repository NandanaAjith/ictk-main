Feature: feature to test login funtionality

  Scenario Outline: Check login is succesful with valid credentials
    Given user is navigated to loginpage
    When user clicks on login button
    Then user enters <username> and <password>
    And clicks on signin button
    Then user is redirected user dashboard

    Examples: 
      | username   | password |
      | useradmin  |    12345 |
      #| superadmin |    12345 |
      #| superadmin |     3214 |
