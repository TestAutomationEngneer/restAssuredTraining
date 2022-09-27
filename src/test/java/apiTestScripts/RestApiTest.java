package apiTestScripts;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestApiTest {

    @Test
    void shouldStartsWithD() {
        String name = "Darek";
        assertThat(name).startsWith("D");
    }
}
