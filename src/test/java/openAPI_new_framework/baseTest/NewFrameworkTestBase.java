package openAPI_new_framework.baseTest;

import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import openAPI_new_framework.client.ApiClient;
import openAPI_new_framework.client.JacksonMapper;
import org.junit.jupiter.api.extension.RegisterExtension;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class NewFrameworkTestBase {
    @RegisterExtension
    protected static WireMockExtension mock = WireMockExtension.newInstance()
            .options(wireMockConfig().dynamicPort())
            .build();

    protected static ObjectWriter writer = new JacksonMapper().create().writer().withDefaultPrettyPrinter();

    protected ApiClient createApiClient(String baseUri) {
        return new ApiClient(() ->
                new RequestSpecBuilder()
                        .setContentType(ContentType.JSON)
                        .addFilter(new RequestLoggingFilter())
                        .addFilter(new ResponseLoggingFilter())
                        .setBaseUri(baseUri)
                        .setConfig(config().objectMapperConfig(
                                objectMapperConfig().jackson2ObjectMapperFactory(
                                        (cls, charset) -> new JacksonMapper().create()))));
    }
}
