# Accreditation User Service Application
	This application is a REST API to take control of accreditation user operations.

Functional requirements
 ```bash
As of this writing, Yieldstreet’s investments are only open to a
ccredited investors​. When new
users register, they have to submit documentation (last two years of tax returns, usually) that
they qualify for the accredited status.
Challenge
Create an application that starts HTTP server exposing a REST API endpoint POST
/user/accreditation​ that receives proof of accreditation for a user. Here’s an example of a
request this endpoint must accept:
POST /user/accreditation
Content-Type: application/json

    {  
        "user_id": "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V",
        "payload": {
            "accreditation_type": "BY_INCOME",
            "documents": [
                {
                "name": "2018.pdf",
                "mime_type": "application/pdf",
                "content": "ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg=="
                },{
                "name": "2019.jpg",
                "mime_type": "image/jpeg",
                "content": "91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo="
                }
            ]
        }
    }

If the request is successfully handled, the endpoint must produce a response that looks like this:
Content-Type: application/json
    {
        "success": true,
        "accredited": true
    }

Requirements:
    1) You must validate the request body of the POST endpoint, ensuring it’s a valid JSON
    object and that it matches the shape of the example above. Return a non-successful
    HTTP response if the request is invalid;
    2) You don’t actually need to determine if a request is marked as accredited or not. Y
    ou
    can use a random number generator to determine whether the accreditation was
    verified;
    3) The only technical requirement is to use Java programming language - other than that,
    feel free to use any frameworks/libraries/tools you’re familiar with;
    4) You must submit a complete, fully packaged project as the solution;

Evaluation considerations:
    Your solution will be evaluated on several points. Is this a complete solution that works? Does it
    build? Does it run? Does it work as intended? How clean is the code? How well is it architected
    and documented?
    If you move on to the next step of the interview process, some of the questions in the next
    rounds will be based on your solution - expect to talk about how to scale your solution, potential
    performance pitfalls, architecture choices, etc.
 ```   
## Technologies(Frameworks and Plugins)
This project I have developed using Intellij IDE and these technologies and frameworks:

	-Java 8
    -Springboot,
    -Gradle,
    -Swagger,
    -Lombok,
    -Actuator,
    -Docker,
	-PMD plugin,
	-Checkstyle plugin,
    -Spring rest.

## About project	
	This project is formed per one SpringBoot Application.
        Notes about application:
            -It is configured to listen 8090 port;
            - This project use swagger plugin, I mean, you can check the endpoint documentation in this url: http://localhost:8090/accreditation-service/swagger-ui.html;
			-Basic the API has this endpoint:

				Post - http://localhost:8090/accreditation-service/user/accreditation - endpoint to submit a documentation that that will return an accredited status;

			-There are unit tests for service layer,
			-There are integration tests for API;
			-This project is using PMD (https://maven.apache.org/plugins/maven-pmd-plugin/) and Checkstyle (https://maven.apache.org/plugins/maven-checkstyle-plugin/) plugins to keep a good quality in -the code.
			-During every build process, these process are executed:
				Execute unit tests for service layer
				Execute integration tests
				Execute Checkstyle verification
				Execute PMD verification	
				build jar file

## Run 
 Inside Intellij IDE:
 ```bash
    -Import the project;
    -Execute Gradle import;
    -Check Enable annotation processing field in Intellij options
    -Start the application running this class AccreditationServiceApplication.
 ```

## Docker
 To use docker you need follow these steps:
 ```bash
	-Build the application,
	-Build docker image with this command: docker build -t accreditation-service:latest . (you need to run this command in root project folder to create the docker image);
    -Execute the docker-compose file with this command: docker-compose up (you need to run this command in root project folder). You can -check if applications are running using the actuator feature, to do do that you need to access this url: http://localhost:8090/accreditation-service/health;
```

If you have questions, please feel free to contact me.