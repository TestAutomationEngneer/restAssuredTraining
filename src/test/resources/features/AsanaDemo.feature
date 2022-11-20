Feature: Testing New Asana project Demo

#  project details hardcoded
  @asana
  Scenario Outline: Get projects details for my workspace
    Given I save data "<Params>"
    Given I have project object
    When  User perform astana GET projects operation
    Then  User is able to see response with projects details

    Examples:
      | Params                                                           |
      | gid=1203406146981980,name=Selenium project,resource_type=project |

    #  project details from example, interpolation
  @asana
  Scenario Outline: Get projects details for my workspace with interpolation
    Given I save data "<Params>"
    Given I have project GET object with interpolation
    When  User perform astana GET projects operation with interpolation
    Then  User is able to see response with projects details with interpolation

    Examples:
      | Params                                                           |
      | gid=1203406146981980,name=Selenium project,resource_type=project |

  @asana
  Scenario Outline: Create a new project
    Given I save data "<Params>"
    Given I have project object with interpolation
    When  User perform astana POST project with interpolation
    Then  User is able to see response with new project

    Examples:
      | Params                                                                               |
      | workspaceID=1201005100247837,project_name=Selenium project,author=Robert Lewandowski |
      | workspaceID=1201005100247837,project_name=RestAssured project,author=Angelina Jolie  |

  @asana
  Scenario Outline: Delete the project
    Given I save data "<Params>"
    When  User perform astana DELETE project
    Then  User is able to see response of deleted project

    Examples:
      | Params                     |
      | projectID=1203406147018647 |


