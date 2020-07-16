# Many-to-Many-Bidirectional

In this article, we will discuss the following:

Many to Many Bidirectional.

More from here:-   

https://dzone.com/articles/introduction-to-spring-data-jpa-part-8-many-to-man

POST : localhost:2003/user/create

{   
          "firstName": "My first name",    
          "lastName":"My last name",  
          "mobile": "9876435234",  
          "email":"hi@mail.com",  
          "roles": [   
              {  
                  "name": "MANAGER",   
                  "description": "Mid Level Managers"  

              },  

              {  

                  "name" : "ACCOUNTS",  

                  "description": "ACCOUNTS USERS"  

              }  

              ]    
}

POST: localhost:8080/role/create

{    

  "name": "ADMIN",  

  "description": "Administrator",  

  "users": [  

      {  

          "firstName": "hello",  

          "lastName":"world",  

          "mobile": "9876435234",  

          "email":"hello@mail.com"  

      },  

      {  

          "firstName": "Hello Good Morning",  

          "lastName":"world",  

          "mobile": "9876435234",  

          "email":"world@mail.com"  

      }  
  
      ]  
  
}   