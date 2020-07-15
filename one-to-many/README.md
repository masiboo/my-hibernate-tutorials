For testing first save debarment by post using Postman 
http://localhost:8080/saveDept
JSON payload :-
{
    "name": "HR"
}

After saving department we can save student list by this Post usin Postman

localhost:8080 /saveStudent/hr
JSON payload :- 
[
    {
        "name": "aaa",
        "mobile": 12345,
        "department": {
           
        }
    },
    {
        "name": "bbb",
        "mobile": 1234500,
        "department": {
            
        }
    }
]