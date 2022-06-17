# chatment-spring-application

This is a maven project 


`execute mvn install`


` java -jar target/chatment-0.0.1-SNAPSHOT.jar`

This should spin up the server at localhost:5000 

API 1: `http://localhost:5000/fact?animal=dog` or `http://localhost:5000/fact?animal=cat` fetches a fact about the animal. 


API 2: `curl --location --request GET 'http://localhost:5000/getfact' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9'`

`As mentioned I put a hardcoded access token eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9 with a Bearer prefix for securing the getfact api`
This API returns the data stored in embedded db
