package day1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.google.gson.JsonObject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HTTPRequestsTest {
    private static String apiKey;
    private int id;

    @BeforeAll
    public static void loadConfig() throws IOException{
        Properties props = new Properties();
        try(InputStream input = HTTPRequestsTest.class.getClassLoader()
                .getResourceAsStream("config.properties")
        ){
            props.load(input);
        }
        apiKey = props.getProperty("reqres.api.key");
    }

    @Test
    @Order(1)
    void getUsers(){
        given()
            .header("x-api-key",apiKey)
        .when() 
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200);
    }

    RegisterRequestBody newUser = new 
        RegisterRequestBody("eve.holt@reqres.in", "pistol");
    
    @Test
    @Order(2)
    void registerUserTest(){
        id = given()
            .headers("x-api-key", apiKey,
             "Content-Type", "application/json")
            .body(newUser)
        .when()
            .post("https://reqres.in/api/register")
        .then()
            .statusCode(200).extract().jsonPath().getInt("id");
    }

    @Test
    @Order(3)
    void userLoginTest(){
        given()
            .headers("x-api-key", apiKey,
             "Content-Type", "application/json")
            .body(newUser)
        .when()
            .post("https://reqres.in/api/login")
        .then()
            .statusCode(200);
    }

    JsonObject data = new JsonObject();

    {
        data.addProperty("name","morpheus");
        data.addProperty("job", "zion resident");
    }

    @Test
    @Order(4)
    void updateUserTest(){
        given()
            .headers("x-api-key", apiKey,
             "Content-Type","application/json")
            .body(data.toString())
        .when()
            .put("https://reqres.in/api/users/"+id)
        .then()
            .statusCode(200);
    }

}