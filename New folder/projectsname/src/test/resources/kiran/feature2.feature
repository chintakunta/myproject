Feature:Logout
@smoketest
Scenario: validate logout operation
Given launch site using"chrome"
When do login with valid data
|    mbno   |  pwd  | 
|7207519505 |kiran  |
And do logout
Then home page will be reopened
And close site
