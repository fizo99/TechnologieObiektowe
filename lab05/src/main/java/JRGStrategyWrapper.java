import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class JRGStrategyWrapper implements JRGStrategy {
    static final List<JRG> JRGS = Collections.unmodifiableList(
            List.of(
                    new JRG("JRG-1",50.06041681642017, 19.9430921693129),
                    new JRG("JRG-2",50.034216415244586, 19.935570792595158),
                    new JRG("JRG-3",50.07679870745459, 19.888040504154123),
                    new JRG("JRG-4",50.037853998244394, 20.00585202880808),
                    new JRG("JRG-5",50.09231965995491, 19.92211985579486),
                    new JRG("JRG-6",50.019370844510384, 20.015670999437578),
                    new JRG("JRG-7",50.094213222124935, 19.97744472695901),
                    new JRG("JRG-Szkoła-Aspirantów-PSP",50.07833305675096, 20.03240462235691),
                    new JRG("JRG-Skawina",49.97736182717588, 19.800510652229956),
                    new JRG("LSP-Lotnisko-Balice",50.073351226659994, 19.78585895394286)
            )
    );

    protected void sendTrucks(Event event, int numberOfTrucks) throws UnableToExecuteStrategyException{
        try {
            List<FireTruck> trucksForAction = collectFreeTrucks(event, numberOfTrucks);
            lockTrucks(trucksForAction);

            Thread.sleep(randomDriveTime());
            if(!event.isFalseAlarm()) Thread.sleep(randomActionTime());
            Thread.sleep(randomDriveTime());

            releaseTrucks(trucksForAction);
        } catch(InterruptedException ex) {
            Logger.getGlobal().info("Interrupt");
        }
    }

    private List<FireTruck> collectFreeTrucks(Event event, int numberOfTrucks) throws UnableToExecuteStrategyException{
        List<Map.Entry<Double, List<FireTruck>>> trucksSortedByDistance = JRGS.stream()
                .map(jrg -> Map.entry(distanceBetweenEventAndJRG(event,jrg), jrg.getFireTrucks()))
                .sorted((e1,e2) -> Double.compare(e2.getKey(), e1.getKey()))
                .collect(Collectors.toList());

        List<FireTruck> selectedFireTrucks = new ArrayList<>();
        for (Map.Entry<Double, List<FireTruck>> doubleListEntry : trucksSortedByDistance) {
            int trucksLeftToCollect = numberOfTrucks - selectedFireTrucks.size();
            List<FireTruck> probableFireTrucks = doubleListEntry.getValue().stream()
                    .filter(fireTruck -> fireTruck.getFireTruckState() instanceof Free)
                    .limit(trucksLeftToCollect)
                    .collect(Collectors.toList());
            selectedFireTrucks.addAll(probableFireTrucks);
            if (selectedFireTrucks.size() == numberOfTrucks) break;
        }
        if(selectedFireTrucks.size() != numberOfTrucks)
            throw new UnableToExecuteStrategyException("Not enough available firetrucks");
        return selectedFireTrucks;
    }

    private double distanceBetweenEventAndJRG(Event event, JRG jrg) {
        return Coordinates.distance(event.getCoords(), jrg.getCoords());
    }

    private void lockTrucks(List<FireTruck> freeFireTrucks) {
        freeFireTrucks.forEach(fireTruck -> {
            Logger.getGlobal().info(fireTruck.getIdentificator() + " is busy");
            fireTruck.setFireTruckState(new Busy());
        });
    }
    private void releaseTrucks(List<FireTruck> busyFireTrucks) {
        busyFireTrucks.forEach(fireTruck -> {
            Logger.getGlobal().info(fireTruck.getIdentificator() + " is free");
            fireTruck.setFireTruckState(new Free());
        });
    }

    private long randomDriveTime() {
        return (long) (random(0.0,3.0) * 1000);
    }

    private long randomActionTime() {
        return (long) (random(5.0,25.0) * 1000);
    }

    private double random(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
