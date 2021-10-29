# REST-Calculator

## Deployment

To run the RabbitMQ instance the following command was used:
docker run --rm -it --name my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

Each module is ran with the following command in its directory:
./mvnw spring-boot:run