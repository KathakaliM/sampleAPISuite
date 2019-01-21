# sampleAPISuite
Steps to run the test suite designed in java and TestNG

Download the file and import in eclipse

Right click on the testng.xml 

Run as TestNG Suite

It will show the log  console

Now  open the file folder from document and open 'test output' folder

I have added two screen recordings videos as well  file name is TestVideo

Also to check the report can open emailable-report.html in browser which will show the entire report summary

Test Methods---
1. numberValidation (requestGet.GetRequestData#numberValidation)
 - verifying diiferent phone numbers(mobile, landline, toll-free) features with line_type and countries data present
 
2.testJSONP_Feature (requestGet.GetRequestData#testJSONP_Feature)
- verifying JSONP  Response body is wrapped with CALLBACK_Function

3.test_CountryEndpoint_Feature (requestGet.GetRequestData#test_CountryEndpoint_Feature)
- verifying CountryEndpoint feature to get all the 232 countries code and dialling_code

4.test_Local_Num_Feature (requestGet.GetRequestData#test_Local_Num_Feature)
- verifying National (Local) Numbers feature to get local format value
