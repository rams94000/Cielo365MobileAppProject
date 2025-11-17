@Tag
Feature: System Testing

@Tag1
Scenario: Verify whether user is able to login the application
And Click on Signin button
And Select the company
Then User should be able to view the dashboard page
@Tag2
Scenario: Ensure that after performing Forgot Password the user receives an email on their registered mobile device.
And Click on forgot password
And Enter registered email in email text field
And Click on send button
Then User should be able to receive email
@Tag3
Scenario: Verify whether after enetring the wrong email and hit the send button user is able to view proper error message
And Click on forgot password
And Enter wrong email in email text field
And Click on send button
Then User should be able to view error message
  