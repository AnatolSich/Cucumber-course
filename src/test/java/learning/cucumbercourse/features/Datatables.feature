Feature: Data Tables

@ListOfStrings
Scenario: Bill Amount Generation
Given I placed an order for the following items
|Cucumber Sandwich|2|20|
When I generate the bill
Then a bill for $40 should be generated




