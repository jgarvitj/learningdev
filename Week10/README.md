Write a microservice application named 

1. meeting-service 
2. participant-service 

Please keep first set of 5 Meeting in the ArrayList 

1. meeting-service
                class Meeting { -- sample model 
                                private int meetingId; 
                                private String topic; 
                                private String startTime; 
                                private String endTime; 
                }
                
                http://localhost:8080/meeting - GET - it should give all the meeting 
                http://localhost:8080/meeting/1234 - GET - it shoudl give me meeting with id 1234 
                http://localhost:8080/meeting/1234/participants - GET - get all the participants of meeting id 1234 (from other service)


Please keep first set of 5 Participant in the ArrayList 

2. participant-serivce 
class Participants {
                private int pId; 
                private String pName; 
                private int meetingId; 
}

                http://localhost:8100/participants - GET -- all participants 
                http://localhost:8100/participant/101 - GET -- participant 101     


Note: Use FEIGN / Rest Template for service communication 

