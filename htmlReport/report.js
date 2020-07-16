$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E2ETest.feature");
formatter.feature({
  "line": 2,
  "name": "Verify E2E cucumber features validations with test website",
  "description": "",
  "id": "verify-e2e-cucumber-features-validations-with-test-website",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 7731233700,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Verify user registration is unsuccessful when checkbox not checked",
  "description": "",
  "id": "verify-e2e-cucumber-features-validations-with-test-website;verify-user-registration-is-unsuccessful-when-checkbox-not-checked",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Register"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user has navigated to \"https://rahulshettyacademy.com/#/index\" URL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user clicks on \"Register\" link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enters all manadatory fields except checkbox and click on Register button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "verify error message is displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://rahulshettyacademy.com/#/index",
      "offset": 23
    }
  ],
  "location": "StepDefinition.user_has_navigated_to_something_url(String)"
});
formatter.result({
  "duration": 4399145800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "StepDefinition.user_clicks_on_something_link(String)"
});
formatter.result({
  "duration": 10993597100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.user_enters_all_manadatory_fields_except_checkbox_and_click_on_Register_button()"
});
formatter.result({
  "duration": 4129232200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_error_message_is_displayed()"
});
formatter.result({
  "duration": 361821100,
  "status": "passed"
});
formatter.after({
  "duration": 219100,
  "status": "passed"
});
formatter.before({
  "duration": 6958894000,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Verify user navigate to login page successfully",
  "description": "",
  "id": "verify-e2e-cucumber-features-validations-with-test-website;verify-user-navigate-to-login-page-successfully",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 11,
      "name": "@Login"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "user has navigated to \"https://rahulshettyacademy.com/#/index\" URL",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "user clicks on \"Login\" link",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "verify login page is displayed",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://rahulshettyacademy.com/#/index",
      "offset": 23
    }
  ],
  "location": "StepDefinition.user_has_navigated_to_something_url(String)"
});
formatter.result({
  "duration": 3319651600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 16
    }
  ],
  "location": "StepDefinition.user_clicks_on_something_link(String)"
});
formatter.result({
  "duration": 11562650000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.verify_login_page_is_displayed()"
});
formatter.result({
  "duration": 610642100,
  "status": "passed"
});
formatter.after({
  "duration": 127300,
  "status": "passed"
});
});