import java.util.List;

public class LocalDangerStrategy implements Strategy{
    private List<FireTruck> fireTruckList;
    LocalDangerStrategy(List<FireTruck> fireTrucks) {
        this.fireTruckList = fireTrucks;
    }

    @Override
    public void execute() {

    }
}
