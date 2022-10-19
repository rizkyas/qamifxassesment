#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login
Feature: Login
  As a user I Want to login into the site with valid or invalid Email or Password and  doing forgot password

  @Valid
  Scenario Outline: Login with a valid credential email and password
    Given I want to navigate to Form Login
    When Login using correct email <email> and password <password>
    And I Checklist Remember me
    And I Click Submit Button
    Then I shouldbe able to dashboard page

    Examples: 
      | email                            | password  |
      | recruitmentqaprofesi@yopmail.com | Qapr0fes1 |

  @InValidFormatEmail
  Scenario Outline: Login with wrong format email and password
    Given I want to navigate to Form Login 1
    When Login using wrong format email <email> and password <password>
    Then Alert Email Format be displayed

    Examples: 
      | email                | password |
      | recruitmentqaprofesi | Qapr0fes |

  @InValid
  Scenario Outline: Login with a invalid credential email and password
    Given I want to navigate to Form Login 2
    When Login using in correct email <email> and password <password>
    And I Checklist Remember me 2
    And I Click Submit Button 2
    Then Alert wrong password be displayed

    Examples: 
      | email                           | password |
      | recruitmentqaprofesi@google.com | Qapr0fes |

  @NullEmailAndPassword
  Scenario Outline: Login with empty credential email and password
    Given I want to navigate to Form Login 3
    When Login using empty email <email> and password <password>
    And I Checklist Remember me 3
    Then Alert Empty email and password be displayed

    Examples: 
      | email | password |
      |       |          |

  @ForgotPassword
  Scenario Outline: Forgot Password
    Given I want to navigate to Form Login 4
    When I Click Forgot Password
    And Show Form Input Email
    And I input Email <email>
    And I Click Button Pulihkan
    Then Alert Successfully be displayed
    And I Open Email
    And Input Verification code <email>

    Examples: 
      | email                            |
      | recruitmentqaprofesi@yopmail.com |
