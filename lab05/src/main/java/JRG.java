

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JRG {
    private static final int FIRE_TRUCKS_COUNT = 5;
    @Getter
    private String identificator;

    @Getter
    private List<FireTruck> fireTrucks;

    @Getter
    private final Coordinates coords;

    JRG(String identificator, double lat, double lon) {
        this.identificator = identificator;
        this.fireTrucks = initFireTrucks();
        this.coords = new Coordinates(lat,lon);
    }

    public boolean hasFreeFireTrucks(int numberOfTrucks) {
        return fireTrucks.stream()
                .filter(fireTruck -> fireTruck.getFireTruckState() instanceof Free)
                .count() >= numberOfTrucks;
    }

    private List<FireTruck> initFireTrucks() {
        List<FireTruck> fireTruckList = new ArrayList<FireTruck>();
        for(int i = 0; i < FIRE_TRUCKS_COUNT; i++){
            fireTruckList.add(new FireTruck(String.format("FT-%s-%d", this.identificator, i)));
        }
        return Collections.synchronizedList(fireTruckList);
    }
}
