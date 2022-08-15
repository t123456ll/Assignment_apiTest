import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class NegativeTest extends BaseTest{
    @Test
    // For testing query without api key
    void negativeTest_NoAPIKey_ShouldFail(){
        given().
                queryParam("start_date", "2022-08-04").
                queryParam("end_date", "2022-08-05").
        when().
                get(baseURI).
        then().
                assertThat().statusCode(403).
                assertThat().body(containsString("API_KEY_MISSING"));
    }

    @Test
        // For testing valid query with end date and api key but default start date
    void negativeTest_ValidQueryDefaultStartDate_ShouldFail(){
        given().
                queryParam("end_date", "2022-08-05").
                queryParam("api_key", APIKEY).
        when().
                get(baseURI).
        then().
                assertThat().statusCode(400).
                assertThat().body(containsString("Date Format Exception"));

    }

    @Test
    // For testing query without parameter
    void negativeTest_NoParam_ShouldFail(){
        given().
        when().
                get(baseURI).
        then().
                assertThat().statusCode(403).
                assertThat().body(containsString("API_KEY_MISSING"));
    }

    @Test
    // For testing query with wrong date format, e.g. yyyymmdd
    void negativeTest_WrongDateFormat_ShouldFail(){
        given().
                queryParam("start_date", "20220804").
                queryParam("end_date", "20220805").
                queryParam("api_key", APIKEY).
        when().
                get(baseURI).
        then().
                assertThat().statusCode(400).
                assertThat().body(containsString("Date Format Exception"));
    }

    @Test
    // For testing query which time range is over 7 days
    void negativeTest_ExceedTimeRange_ShouldFail(){
        given().
                queryParam("start_date", "2022-08-01").
                queryParam("end_date", "2022-08-11").
                queryParam("api_key", APIKEY).
                when().
                get(baseURI).
                then().
                assertThat().statusCode(400).
                assertThat().body(containsString("Date Format Exception"))
                ;
    }


}
