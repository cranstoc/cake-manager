# Cake Manager #

## Introduction ##

This is a simple Cake Manager REST service utilising Spring Boot

## Endpoints ##

| Endpoint           | Description         |
|--------------------|---------------------|
| GET /cakes         | Get all cakes       |
| GET /cake/{id}     | Get cake with id    |
| POST /cake         | Create a new cake   |
| PUT /cake/{id}     | Update cake with id |
| DELETE /cake/{id}  | Delete cake with id |

## Requirements ##

Requires Java 17

## Building ##

The project can be built (including all unit and integration tests) with command:

`mvn clean install`

## Running ##

The project can be run with command:

`mvn spring-boot:run`

Endpoints are available on http://localhost:8080, e.g. GET http://localhost:8080/cakes