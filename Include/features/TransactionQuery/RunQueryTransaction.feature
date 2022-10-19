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
@tag
Feature: Runing Correct Query Transaction
  I want to check query transaction invoice

  @tag1
  Scenario Outline: Run Query for Invoice No DX01.006.009
    Given I Navigate to database administration
    When I connect to database
    And I Run Query for Invoice No DX01.006.009
    And result query Invoice No DX01.006.009 is show
    Then Validate the result is invoice_no <invoice_no> and whole_saler <whole_saler> and delivery_service <delivery_service> and date_order <date_order>

    Examples: 
      | invoice_no   | whole_saler | delivery_service | date_order |
      | DX01.006.009 | Budi       |  JNE Reguler      | 2022-05-04 |

  @tag2
  Scenario Outline: Run Query for Invoice No DX01.005.011
    Given I Navigate to database administration
    When I connect to database
    And And I Run Query for Invoice No DX01.005.011
    And result query Invoice No DX01.005.011 is show
    Then Validate the result is invoice_no <invoice_no> and whole_saler <whole_saler> and delivery_service <delivery_service> and date_order <date_order>
      | invoice_no   | whole_saler | delivery_service | date_order |
      | DX01.005.011 | Bedjo       |                  | 2022-05-03 |
