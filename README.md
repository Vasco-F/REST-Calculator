# REST-Calculator

## Design Decisions


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
- Total: Around 8 hours
    - Some time was taken reading about the MDC but i had no time to try and implement it
