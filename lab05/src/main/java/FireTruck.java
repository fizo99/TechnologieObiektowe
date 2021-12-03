import lombok.Getter;
import lombok.Setter;

public class FireTruck {
    @Getter
    private String identificator;
    @Getter
    @Setter
    private FireTruckState fireTruckState;
    FireTruck(String identificator){
        this.identificator = identificator;
        this.fireTruckState = new Free();
    }

    @Override
    public String toString() {
        return identificator;
    }
}
