Feature:Login
@someketest
Scenario: validate site launching
Given launch site using"chrome"
Then title contains"Free sms"
And close site
Scenario Outline: validate login operation
Given launch site using"chrome"
When enter mobile number as"<x>"
And enter password as"<y>"
And click login
Then validate output for criteria"<z>"
And close site

Examples:
|    x     |      y       |      z      |
|7207519505|    kiran     |all_valid    |
|          |    kiran     |mobile_blank |
|7207519505|              |pwd_blank    |
|7207519506|    kiran     |mbno_invalid |
|7207519505|   kiran93    |pwd_invalid  |