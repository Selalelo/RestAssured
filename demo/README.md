# REST Assured API Test Demo

This Maven project contains introductory API tests written in Java with REST Assured and JUnit 5. The tests call the Reqres demo API to retrieve users, register and log in a test user, and update a user record.

## Requirements

- JDK 21
- Maven
- Network access to the Reqres API
- A Reqres API key configured in `src/test/resources/config.properties`

## Configure

Copy `src/test/resources/config.example.properties` to `src/test/resources/config.properties`, then replace the placeholder with your Reqres API key. The local `config.properties` file is ignored by Git so credentials are not committed.

## Run

From the repository root:

```bash
mvn -f demo/pom.xml test
```

The tests depend on the external Reqres service and its availability.

## Test code

- `HTTPRequestsTest` contains the ordered GET, registration, login, and update tests.
- `RegisterRequestBody` models the JSON body used for registration and login.
