@priority
Feature: Retail Home Page

  Background: Verify user is on the home page
    Given User is on the retail home page

  @verifySidebar
  Scenario: Verify Shop by Department sidebar
    When User click on All section
    Given User is on the retail home page
    Then below options are present in shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automotive |

  @sidebarOutline
  Scenario Outline: Verify department sidebar options
    When User click on All section
    And User on <department>
    Then below options are present in department
      | <optionOne> | <optionTwo> |
    Examples:
      | department    | optionOne                      | optionTwo                |
      | 'Electronics' | TV & Video                     | Video Games              |
      | 'Computers'   | Accessories                    | Networking               |
      | 'Smart Home'  | Smart Home Lightning           | Plugs and Outlets        |
      | 'Sports'      | Athletic Clothing              | Exercise & Fitness       |
      | 'Automotive'  | Automative Parts & Accessories | MotorCycle & Powersports |