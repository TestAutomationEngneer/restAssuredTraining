package openAPI_new_framework.data.factories;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    List<Integer> availableRooms = new ArrayList<>();


    public List<Integer> findAllAvailableRooms() {
        availableRooms = List.of(7, 12, 18, 22, 23, 88);
        //please imagine that this method make real call to PostgreSQL DB :-)
        return availableRooms;  //size 6
    }
}
