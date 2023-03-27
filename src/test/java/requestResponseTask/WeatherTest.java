package requestResponseTask;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WeatherTest extends TestBase {

    @DisplayName("Should get response with weather info for city ID")
    @ParameterizedTest(name = "{index}. Test for city {0} with id {2}")
    @CsvFileSource(resources = "/cities.csv")
    @Tag("weather")
    @Tag("regression")
    public void shouldGetWeatherInfoByCityIDTestCsvFileSource(String city, String country, int id) {
        given().
                spec(WeatherRequest.getWeatherInfoByCityID(id)).
        when().
                get().
        then().
                spec(WeatherResponse.getResponseSpec(city, country, id));
    }
}
