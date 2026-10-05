# REST Assured API Tests

A small Java project for practicing automated REST API testing with REST Assured and JUnit 5. The current test suite sends requests to the Reqres demo API and checks the HTTP status codes for user listing, registration, login, and updating a user.

## Project layout

- `demo/pom.xml` — Maven project configuration and dependencies.
- `demo/src/test/java/day1/HTTPRequestsTest.java` — API request tests.
- `demo/src/test/java/day1/RegisterRequestBody.java` — request body model used for registration and login.
- `demo/src/test/resources/config.properties` — API test configuration, including the Reqres API key property.

## Requirements

- JDK 21
- Maven
- Network access to `reqres.in`

## Run the tests

From the repository root, run:

```bash
mvn -f demo/pom.xml test
```

The tests are ordered and currently expect successful responses from the Reqres demo API. Because they call an external service, their results depend on that service being available and accepting the configured API key.

## Configuration

The tests read `reqres.api.key` from `demo/src/test/resources/config.properties` and send it in the `x-api-key` request header. Use a valid key for the Reqres environment you are testing against. Do not commit private or production credentials to source control.
