import java.util.List;

public class FireStrategy implements Strategy{
    private List<FireTruck> fireTruckList;
    FireStrategy(List<FireTruck> fireTrucks) {
        this.fireTruckList = fireTrucks;
    }

    @Override
    public void execute() {

    }
}
