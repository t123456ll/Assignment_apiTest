import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PositiveTest extends BaseTest{

    @Test
    // For testing valid start date, end date and api key
    void positiveTest_ValidQuery_ShouldSucceed(){
        ValidatableResponse response =
                given().
                        queryParam("start_date", "2022-08-04").
                        queryParam("end_date", "2022-08-05").
                        queryParam("api_key", APIKEY).
                when().
                        get(baseURI).
                then().
                        assertThat().statusCode(200);
    }

    @Test
    // For testing valid query with start date and api key but default end date
    void positiveTest_ValidQueryDefaultEndDate_ShouldSucceed(){
        ValidatableResponse response =
                given().
                        queryParam("start_date", "2022-08-04").
                        queryParam("api_key", APIKEY).
                when().
                        get(baseURI).
                then().
                        assertThat().statusCode(200);
    }


    @Test
    // For testing valid query with start date and end date but default api key
    void positiveTest_ValidQueryDefaultAPIKey_ShouldSucceed(){
        given().
                queryParam("start_date", "2022-08-04").
                queryParam("end_date", "2022-08-05").
                queryParam("api_key", "DEMO_KEY").
        when().
                get(baseURI).
        then().
                assertThat().statusCode(200);
    }

    @Test
        // For testing valid query with api key only
    void positiveTest_ValidQueryNoDate_ShouldSucceed(){
        given().
                queryParam("api_key", APIKEY).
        when().
                get(baseURI).
        then().
                assertThat().statusCode(200);
    }

    @Test
    void positiveTest_NoDate_ShouldSucceed(){
        given().
                queryParam("api_key", APIKEY).
        when().
                get(baseURI).
        then().
                assertThat().statusCode(200);

    }

    @Test
    void positiveTest_StartDateLaterThanEndDate_ShouldSucceed(){
        given().
                queryParam("start_date", "2022-08-05").
                queryParam("end_date", "2022-08-04").
                queryParam("api_key", APIKEY).
        when().
                get(baseURI).
        then().
                assertThat().statusCode(200);
    }


}
