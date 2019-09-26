# Danial-UserCart
Application is built using Maven,
 Springboot version 1.5.7.RELEASE
 H2 Version 1.4.196
 mysql-connector-java version 8.0.13

JMS listener will consume queue "company.usercart.add" with parameters "product_id" and "user_id".

The ideal solution will have a separate User entity and a Product entity and the UserCart entity would have foreign keys from User and Product Entities to ensure data integrity.
Product-listener-core module acts as the service with data models to save data to the embedded H2 database while product-listener acts as the listener listening to the embedded ActiveMQ server.

Build cmd: mvn clean install
