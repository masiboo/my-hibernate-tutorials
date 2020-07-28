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
        "name": "student name 1",  
        "mobile": 12345,  
        "department": {  
             
    }
    },
    {
        "name": "student name 1",
        "mobile": 1234500,
        "department": {
            
        }
    }
]

http://localhost:8080/addDept   
JSON payload :-  
{  
    "name": "test dept",  
    "studentList":[    
        {  
        "name": "student name",  
        "mobile": 111333  
        },  
        {  
        "name": "student name2",  
        "mobile": 111333234  
        }  
    ]  
}  