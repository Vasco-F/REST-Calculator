# REST-Calculator

## Design Decisions

The modules were kept seperated because i was not aware of the Maven Multi-Module configuration and after discovering it, i was not sure if that was the desired architecture. 
Additionally, it made sense to me to keep the modules independent of each other due to the rabbitMQ component connecting each other.
Not sure if it was the correct approach but after searching how to implement the Maven Multi-Module solution, i wasn't able to develop a working solution with the time i had available.

## Deployment

To run the RabbitMQ instance the following command was used:

docker run --rm -it --name my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

Each module is ran with the following command in its directory:

./mvnw spring-boot:run

## Time Usage

- Basic solution without any bonus points: 3 hours
- Logback-access bonus point: 4 hours
    - Read a lot and did not find the most appropriate solution
        I wanted to specify the response body in each logging for better debugging
- Unique request identifier: 30 minutes
    - Not sure if its the appropriate solution
- Maven Multi-Module: 1 hour
    - Not corretly implemented, but some time was used to research and to try and implement it
- Total: Around 9 hours
    - Some time was taken reading about the MDC but i had no time to try and implement it

## Future Work

- Using Docker-Compose to separate the modules between services
- Implement the MDC feature
- Possibily improve the RabbitMQ settings to achieve a better performance
- After using Docker to deploy the solution, test the scalability of the system by replicating the components


## Disclaimer

This project was developed in the scope of the WIT Software Challenge by Vasco Ferreira.
