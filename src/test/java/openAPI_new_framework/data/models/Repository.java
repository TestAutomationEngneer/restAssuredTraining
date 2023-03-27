package openAPI_new_framework.data.models;

import openAPI_new_framework.data.factories.DataSource;

import java.util.List;

public class Repository {

    private DataSource dataSource;
    private List<Integer> hotelRooms;

    public Repository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Integer> findAll() {
        hotelRooms = dataSource.findAllAvailableRooms();
        return hotelRooms;
    }

    public int roomsSize() {
        return hotelRooms.size();
    }
}
