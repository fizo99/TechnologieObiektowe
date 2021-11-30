

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class JRG {
    private static final int FIRE_TRUCKS_COUNT = 5;
    private String identificator;

    @Getter
    private List<FireTruck> fireTrucks;

    @Getter
    private double lat;
    @Getter
    private double lon;

    JRG(String identificator, double lat, double lon) {
        this.identificator = identificator;
        this.fireTrucks = initFireTrucks();
        this.lat = lat;
        this.lon = lon;
    }
    public void triggerEvent(EventType eventType) {
        if(eventType.equals(EventType.FIRE)){
            new FireStrategy(this.fireTrucks).execute();
        }else {
            new LocalDangerStrategy(this.fireTrucks).execute();
        }
    }
    private List<FireTruck> initFireTrucks() {
        List<FireTruck> fireTruckList = new ArrayList<FireTruck>();
        for(int i = 0; i < FIRE_TRUCKS_COUNT; i++){
            fireTruckList.add(new FireTruck(String.format("FT-%s-%d", this.identificator, i)));
        }
        return fireTruckList;
    }
}
