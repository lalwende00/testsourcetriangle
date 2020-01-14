
Feature: Weinberg - Myers Triangle
  As a user,
  I want to give a set of 3 lengths to a computer
  and be told what kind of triangle it is if it represents a triangle.

  # In this scenario, the user enters the lengths with a correct format describing an irregular triangle
  Scenario Outline: Irregular Triangle

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "This triangle is Irregular: It has 3 different sides"

    Examples:
    |   lengths   |
    | "(2, 3, 4)" |
    |  "(2,3,4)"  |
    |  "(4,5,6)"  |
    | "(7, 8, 9)" |


  # In this scenario, the user enters the lengths with a correct format describing an isosceles triangle
  Scenario Outline: Isosceles Triangle

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "This triangle is isosceles: It has 2 equals sides."

    Examples:
      |   lengths   |
      | "(3, 3, 4)" |
      |  "(3,3,4)"  |
      |  "(4,4,6)"  |
      | "(7, 7, 9)" |

  # In this scenario, the user enters the lengths with a correct format describing an equilateral triangle
  Scenario Outline: Isosceles Triangle

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "This triangle is Equilateral: All its sides have the same length."

    Examples:
      |   lengths   |
      | "(3, 3, 3)" |
      |  "(3,3,3)"  |
      |  "(6,6,6)"  |
      | "(7, 7, 7)" |

  # From here on out, we care about scenarios where things go wrong.

  # Given lengths leading to existent triangles but that are rejected by the program:
  Scenario Outline: Rejected Triangle

    Given I Write the length <lengths>
    When I press Enter
    # We can choose to tune the application with finer details by changing the nature of the
    # expected response.
    # This response is the same in many fundamentally different cases
    Then I should be told "a b and c have to be between 0 and 9"

    Examples:
      |   lengths   |
      | "(11, 12, 13)" |
      |  "(13,13,13)"  |
      |  "(16,26,41)"  |
      | "(17, 17, 17)" |

  # In this scenario, the user enters the lengths with a correct format describing a non-existent triangle
  Scenario Outline: Non-existent Triangle

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "This triangle does not exist"

    Examples:
      |   lengths   |
      | "(1, 2, 3)" |
      |  "(1,2,3)"  |
      |  "(2,3,6)"  |
      | "(4, 4, 9)" |


  # In this scenario, the user enters the lengths with a incorrect format
  Scenario Outline: Invalid Format

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "Invalid format, please enter lengths with format (a,b,c) or (a, b, c)"

    Examples:
      |   lengths   |
      # Deviations with respect to format (2, 2, 3)
      | "(2,  2, 3)" |
      | "(2, 2,  3)" |
      | "(2, 2, 3 )" |
      | "(2, 2 , 3)" |
      | "(2 , 2, 3)" |
      | "( 2, 2, 3)" |
      | "2, 2, 3)" |
      | "(2, 2, 3" |
      | "2, 2, 3" |
      # Deviations with respect to format (2,2,3)
      |  "(2 ,2,3)"  |
      |  "( 2,2,3)"  |
      |  "(2,2 ,3)"  |
      |  "(2,2,3 )"  |
      |  "2,2,3)"  |
      |  "(2,2,3"  |
      |  "2,2,3"  |

  # In this scenario, the user enters the lengths with both an incorrect format and lengths that cannot describe a
  # triangle. Effectively, the user enters more or less than 3 lengths.
  Scenario Outline: More or less than three lengths

    Given I Write the length <lengths>
    When I press Enter
    Then I should be told "A triangle has three sides, please enter lengths with format (a,b,c) or (a, b, c)"

    Examples:
      |   lengths   |
      | "(3)" |
      # Deviations with respect to format (2, 2, 3)
      | "(2, 3)" |
      | "(2, 2, 3, 4)" |
      | "(2, 2, 3, 4, 5)" |

      # Deviations with respect to format (2,2,3)
      |   "(2,3)" |
      |  "(2,2,3,4)"  |
      |  "(2,2,3,4,5)"  |

