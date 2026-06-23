Proyecto personal de presentación para dar a conocer las diferentes tecnologías actuales en respuesta a las necesidades de un proyecto actual.
El Proyecto trata acerca de una gestión de un parking con sus clientes, los vehículos de los mismos y una acción de entrada/salida de vehículos, descripción del vehículo, gestión de errores centralizados y por microservicio)
Todo se realizará mediante microservicios dockerizados:
    i. Clientes: Gestión básica de clientes utilizando MongoDB como Bdd
    ii. Gestión de vehículos de cliente, matrícula y descripción entre otros datos, con acciones de E/S de un parking. Tiene sincronización síncrona con el microservicio de clientes
     iii. Carga de histórico en Oracle y Mysql en comunicación asíncrona con Kafka
    iV. Cargas y comunicación de ETLs mediante webservices y JSON
Lenguajes y tecnologías utilizadas: 
    i. Back: Java 25, Spring Boot 4.0.7, Spring Cloud(Config Server), Eureka(Discovery Server), Docker, Hybernate\JPA, Spring Data, Feign, Kafka, API Gateway y Shell Scripting con Java
    ii. Bbdd: MongoDB, PostgreSQL, Oracle y Mysql
    iii. Pruebas unitarias mediante Postman, SOAP y Junit
    iv. OpenApi y Swagger
