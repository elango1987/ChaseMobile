Feature: Chase Login

Scenario: User Installs and Launches the app for the first time
Given The user installs the app
When the user launches the app
Then the Alternate log on screen is displayed.

Scenario: User taps on Enroll button in the alternate log on screen
Given the user is on the Alternate log on screen
When the user taps on Enroll button
Then the Basic Info screen is displayed

Scenario: User taps on Log on in the Alternate log on screen
Given the user is on Alternate log on screen
When the user taps on Log on
Then the BAU log on screen is displayed
