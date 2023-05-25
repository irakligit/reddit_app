package stepObjects.boredApi;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BoredAppSteps {
    public Response getBoredApi(){
        return given()
                .contentType("application/json")
                .get("https://boredapi.free.beeceptor.com/my/api/path");
    }
}
