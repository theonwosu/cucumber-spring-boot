Feature: Bag more functionalities

  Scenario: Putting one thing in the bag
    Given the user can access employee
    When the user adds an employee
    And the user can clear employee list
    Then the bag is empty
