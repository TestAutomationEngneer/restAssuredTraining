package openAPI_new_framework.mockApiTest;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTrainingTest {

    //ParameterResolved - pozwala zdefiniować własne parametry, np potrzebuje randomowego Stringa


    @Test
    @ExtendWith(ProvideRandomStringResolver.class)
    public void shouldCreateRandomStudentName(String randomString, String randomAdres, String randomCity) {
        String studentName = randomString;
        String radnomAdres = randomAdres;
        String randomCityr = randomCity;
        System.out.println(studentName);
        System.out.println(radnomAdres);
        System.out.println(randomCityr);
        assertThat(studentName).hasSize(10);
    }
}
