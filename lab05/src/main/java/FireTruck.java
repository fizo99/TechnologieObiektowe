import lombok.Getter;
import lombok.Setter;

public class FireTruck {
    private String identificator;
    @Getter
    @Setter
    private FireTruckState fireTruckState;
    FireTruck(String identificator){
        this.identificator = identificator;
        this.fireTruckState = new Free();
    }
}
