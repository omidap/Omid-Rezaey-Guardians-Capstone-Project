@regressionRetail
Feature: Retail Home Page

  @verifySidebar
  Scenario: Verify Shop by Department sidebar
    Given User is on retail website
    When User click on All section
    Then below options are present in shop by Department sidebar
      | Electronics | Computers | Smart Home | Sports | Automotive |

  @sidebarOutline
  Scenario Outline: Verify department sidebar options
    Given User is on retail website
    When User click on All section
    And User on <department>
    Then below options are persent in department
      | <optionOne> | <optionTwo> |

    Examples:
      | Department  | OptionOne                      | OptionTwo                |
      | Electronics | Tv & Video                     | Video Games              |
      | Computers   | Accessories                    | Networking               |
      | Smart Home  | Smart Home Lightning           | Plugs and Outlets        |
      | Sports      | Athletic Clothing              | Excise & Fitness         |
      | Automotive  | Automative Parts & Accessories | MotorCycle & Powersports |