import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class BaseTest {
    public static String baseURI = "https://api.nasa.gov/neo/rest/v1/feed";
    public static String APIKEY = "9thY4DlSwVmvZV8wfWENGzHSnoHhiunY6VbRsT13";


    public static ValidatableResponse getRequest(String endpoint, int statusCode) {
        RestAssured.baseURI = baseURI;
        ValidatableResponse response = given().when().get(endpoint).then().assertThat().statusCode(statusCode);
        return response;
    }






}
