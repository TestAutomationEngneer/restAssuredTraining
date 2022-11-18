package openAPI_new_framework.mockApiTest;

import lombok.extern.slf4j.Slf4j;
import openAPI_new_framework.data.factories.DataSource;
import openAPI_new_framework.data.models.Repository;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
public class MockitoHotelTest {

    @Test
    public void shouldGetAvailableRoomsFromDB() {

        DataSource dataSource = new DataSource();
        Repository repository = new Repository(dataSource);
        log.info("Size = " + repository.findAll().size());
        assertThat(repository.findAll().size()).isGreaterThan(0);

    }

    @Test
    public void shouldGetAvailableRoomsUsingMock() {

        //List.of(7, 12, 18, 22, 23, 88);

        DataSource dataSource = mock(DataSource.class);
        Repository repository = new Repository(dataSource);
        List<Integer> actualRooms = repository.findAll();
        log.info("Size = " + repository.findAll().size());
        assertThat(repository.findAll().size()).isGreaterThan(0);
    }

    @Test
    public void shouldGetAvailableRoomsUsingMocks() {

        List<Integer> expecteRoomsList = List.of(7, 12, 18, 22, 23, 88);

        DataSource dataSource = mock(DataSource.class);
        Repository repository = new Repository(dataSource);
        when(repository.findAll()).thenReturn(expecteRoomsList);
        log.info("Size = " + repository.findAll().size());
        assertThat(repository.findAll().size()).isGreaterThan(0);
    }
    @Test
    public void shouldGetAvailableRoomsUsingMocksBDD() {

        List<Integer> expecteRoomsList = List.of(7, 12, 18, 22, 23, 88);

        DataSource dataSource = mock(DataSource.class);
        Repository repository = new Repository(dataSource);
        given(repository.findAll()).willReturn(expecteRoomsList);
        log.info("Size = " + repository.findAll().size());
        assertThat(repository.findAll().size()).isGreaterThan(0);
    }
}
