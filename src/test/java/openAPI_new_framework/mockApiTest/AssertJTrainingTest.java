package openAPI_new_framework.mockApiTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import openAPI_new_framework.baseTest.MockTestBase;
import openAPI_new_framework.client.ApiClient;
import openAPI_new_framework.data.factories.StudentFactory;
import openAPI_new_framework.data.models.Car;
import openAPI_new_framework.data.models.Employee;
import openAPI_new_framework.data.models.StudentDTO;
import openAPI_new_framework.data.models.Transaction;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTrainingTest extends MockTestBase {
    private ApiClient api;
    private String studentName;

    private StudentFactory studentFactory;
    private final String STUDENT_PATH = "/studentDetails/.*";

    @BeforeEach()
    public void createApiClient() {
        studentFactory = new StudentFactory();
        api = createApiClient(mock.baseUrl());
        studentName = RandomStringUtils.random(8, true, false).toLowerCase();

    }
// - AssertJ surowy kod bez endpointów
    @Test
    public void differentAssertionTest() {

        //1. Porówanie liczb
//        int a = 33;
//        int b = 44;
//        assertThat(a).isEqualTo(44);

        //2. Porównanie list
        List<Integer> totolotekWczoraj = List.of(3, 4, 6, 7, 33, 43, 44);
        List<Integer> totolotekDzisiaj = List.of(3, 4, 6, 7, 33, 43, 44);

//       assertThat(totolotekWczoraj).usingRecursiveComparison().isEqualTo(totolotekDzisiaj); //pass
//        assertThat(totolotekWczoraj).contains(7); //pass
//        assertThat(totolotekWczoraj).containsExactlyInAnyOrder(44, 7, 33, 3, 4, 6, 43); //fail



        //3. Porówanie obiektów
        Car toyota = new Car("Toyota", true);
        Car toyota2 = new Car("Toyota", true);

//        assertThat(toyota).isEqualTo(toyota2); //fail
//        assertThat(toyota).isEqualToComparingFieldByFieldRecursively(toyota2); //deprecated
//        assertThat(toyota).usingRecursiveComparison().isEqualTo(toyota2); //pass
//        assertThat(toyota).usingRecursiveComparison().isNotEqualTo(toyota2); //fail

    }

    @Test
    public void differentEmployeeTest() {
        //ACTUAL
        Employee jarek = new Employee(UUID.randomUUID(), "Jaroslaw", 66, Instant.now());
        Employee donald = new Employee(UUID.randomUUID(), "Donald", 63, Instant.now());
        Employee zbigniew = new Employee(UUID.randomUUID(), "Zbigniew", 36, Instant.now());
        Employee dorota = new Employee(UUID.randomUUID(), "Dorota", 46, Instant.now());

        //EXPECTED
        Employee angelina = new Employee(UUID.randomUUID(), "Jaroslaw", 66, Instant.now());
        Employee brad = new Employee(UUID.randomUUID(), "Donald", 63, Instant.now());
        Employee salma = new Employee(UUID.randomUUID(), "Zbigniew", 36, Instant.now());
        Employee dorota2 = new Employee(UUID.randomUUID(), "Dorota", 46, Instant.now());

        //LISTS
        List<Employee> expectedEmployees = List.of( brad, salma, dorota2, angelina);
        List<Employee> actualEmployees = List.of(jarek, donald, zbigniew, dorota);


        //Assercje
//        assertThat(actualEmployees).usingRecursiveComparison().
//               isEqualTo(expectedEmployees); //fail
//        assertThat(actualEmployees).usingRecursiveComparison().
//                ignoringCollectionOrder().
//                isEqualTo(expectedEmployees); //fail
//        assertThat(actualEmployees).usingRecursiveComparison().
//                ignoringCollectionOrder().
//                ignoringFieldsOfTypes(UUID.class, Instant.class).
//                isEqualTo(expectedEmployees); //pass


    }


    @Test
    public void shouldCreateNewTransactionWithSoftAssertion() throws JsonProcessingException {
        Transaction expectedTransaction = Transaction.getExpectedTransactionObject();
        Transaction actualTransaction = Transaction.getActualTransactionObject();

        SoftAssertions softAssertion = new SoftAssertions();

        softAssertion.assertThat(actualTransaction.getOwnerFirstName())
                .as("Owner first name is wrong")
                .isEqualTo(expectedTransaction.getOwnerFirstName());

        softAssertion.assertThat(actualTransaction.getOwnerLastName())
                .as("Owner last name is wrong")
                .isEqualTo(expectedTransaction.getOwnerLastName());

        softAssertion.assertThat(actualTransaction.getAmount())
                .as("wrong amount")
                .isGreaterThan(BigDecimal.valueOf(90));  //zmienić na 190

        softAssertion.assertThat(actualTransaction.getCardType())
                .as("wrong card type")
                .isEqualTo(actualTransaction.getCardType());

        softAssertion.assertThat(actualTransaction.getCurrency())
                .as("wrong currency")
                .isEqualTo(expectedTransaction.getCurrency());

        softAssertion.assertThat(actualTransaction.getProducts())
                .as("wrong product list")
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedTransaction.getProducts());

        softAssertion.assertThat(actualTransaction.getPaymentDate())
                .as("wrong date class type")
                .isInstanceOf(Instant.class);

        softAssertion.assertThat(actualTransaction.getPaymentDate())
                .as("wrong date time")
                .isBefore(Instant.now());

        softAssertion.assertThat(actualTransaction.is3DSecure())
                .as("wrong 3d")
                .isEqualTo(true);  //zmienić na false
        // Don't forget to call assertAll() otherwise no assertion errors are reported!
        softAssertion.assertAll();
    }
}
