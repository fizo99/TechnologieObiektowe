import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FireStrategy implements JRGStrategy {
    @Override
    public void execute(JRG jrg, Event event){
        // TODO implement strategy for fire
        List<FireTruck> listOfAvailableTrucks = new ArrayList<>(jrg.getFireTrucks())
                .stream()
                .filter(fireTruck -> fireTruck.getFireTruckState() instanceof Free)
                .collect(Collectors.toList());

        List<FireTruck> listOfBusyTrucks = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            int randomID = (int) ((Math.random() * listOfAvailableTrucks.size()));
            listOfBusyTrucks.add(listOfAvailableTrucks.remove(randomID));
        }
        listOfBusyTrucks.forEach(fireTruck -> fireTruck.setFireTruckState(new Busy()));


    }
}
