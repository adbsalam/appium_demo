Feature: Home Screen Rate List

  Scenario: HomeScreen performance
    Given App is running and home screen is shown
    Then Check if all visible items are as expected
    When I add amount and click on fetch button
    Then Check if table history loaded or not

