Feature: Rest API training


  Scenario: Get Student details
    Given Student object is created
    When User send GET request
    Then User is able to read student details