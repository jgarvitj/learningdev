Objective:
Given the architecture diagram from the manage you are asked to create an end to end program flow with following pointers. 
The client or CLI is the junit test case you have go have
The test cases to be written before the development code to test – with Mockito  - package com.training.mockito
Once the development test cases to be written for pass case, fail case and when the business logic throws exception (use custom exception )  - com.training.tests 
Controller package should take the request and route to service layer  - com.training.controller 
The service layer will check if the data sent is valid (check if the name of the user is min 4 chars) – then send it to DAO layer  - com.training.service 
In the DAO layer once the object is got, put a message saying “Record Got Successfully” -com.training.dao 
Have appropriate contract / interfaces  - com.training.interfaces 
Keep all exception in – com.training.exceptions 

Status:
This is the basic structure of the project. Mockito is left and shall be soon completed.

To do:
Add more functions and mock them using mockito.