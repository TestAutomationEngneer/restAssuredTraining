package openAPI_new_framework.mockApiTest;

import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@DisplayName("Student Service is up and running")
public class NestedTest {


        @Test
        @DisplayName("When Student object is created")
        void createNewStudent() {
            System.out.println("Student object created");
        }

        @Nested
        @Order(1)
        @DisplayName("I can perform")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class GetStudentTest {


            @Test
            @Order(1)
            @DisplayName("GET student details")
            void getStudentByid() {
                System.out.println("Student details: name=Angelina, date=22.11.2011");
            }


            @Test
            @Order(2)
            @DisplayName("UPDATE student details")
            void updateStudentByid() {
                System.out.println("Student details updated: name=Salma, date=22.11.2011");
            }
        }

        @Nested
        @Order(2)
        @DisplayName("I can persist the object")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class PersistDataTest {

            @Test
            @Order(1)
            @DisplayName("in Postgres DB")
            void studentSavedToPostgres() {
                System.out.println("Student saved to Postgres: name=Angelina, date=22.11.2011");
            }


            @Test
            @Order(2)
            @DisplayName("in Kafka")
            void studentSavedToKafka() {
                System.out.println("Student saved to Kafka: name=Angelina, date=22.11.2011");
            }
        }

        @Nested
        @Order(3)
        @DisplayName("I can run University service")
        @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
        class UniversityServiceTest {

            @Test
            @Order(1)
            @DisplayName("and present the object in University dashboard")
            void shouldPresentStudentInDashboard() {
                System.out.println("Student is presented in University dashboard: name=Salma, date=22.11.2011");
            }


            @Test
            @Order(2)
            @DisplayName("and send the object to DownStream")
            void shouldSendToDownStream() {
                System.out.println("Student has been sent to DownStream in University service: name=Salma, date=22.11.2011");
            }


            @Test
            @Order(3)
            @DisplayName("and DELETE student")
            void deleteStudentByid() {
                System.out.println("Student Salma - DELETED");
            }
        }
    }
