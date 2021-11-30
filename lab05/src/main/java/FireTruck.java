import lombok.Getter;

public class FireTruck {
    private String identificator;
    @Getter
    private FireTruckState fireTruckState;
    FireTruck(String identificator){
        this.identificator = identificator;
        this.fireTruckState = new Free();
    }
}
