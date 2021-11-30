import java.util.List;
import java.util.stream.Collectors;

public class SKKM {
    private static class Strategies {
        private static final JRGStrategy FIRE_STRATEGY = new FireStrategy();
        private static final JRGStrategy LOCAL_DANGER_STRATEGY = new LocalDangerStrategy();
    }
    private static List<JRG> jrgs = List.of(
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
    );

    public void processEvent(Event event) throws Exception {
        List<JRG> jrgs = satisfyingJRGSForEvent(event);
        if(jrgs.size() == 0) {
            throw new Exception("No jrgs left. Ending programme.");
        }else{
            JRGStrategy strategy = suitableStrategy(event.getType());
            JRG jrg = jrgs.get(0);
            strategy.execute(jrg,event);
        }
    }

    private JRGStrategy suitableStrategy(EventType eventType) {
        if(eventType.equals(EventType.FIRE)){
            return Strategies.FIRE_STRATEGY;
        }else {
            return Strategies.LOCAL_DANGER_STRATEGY;
        }
    }

    private List<JRG> satisfyingJRGSForEvent(Event event) {
        return jrgs.stream()
                .filter(jrg -> this.hasEnoughTrucks(jrg, event))
                .sorted(new DistanceComparator(event))
                .collect(Collectors.toList());
    }

    private boolean hasEnoughTrucks(JRG jrg, Event event) {
            int availableFireTrucks = (int) jrg.getFireTrucks()
                    .stream()
                    .filter(fireTruck -> fireTruck.getFireTruckState() instanceof Free)
                    .count();
            if(event.getType().equals(EventType.FIRE)){
                return availableFireTrucks >= 3;
            }else if(event.getType().equals(EventType.LOCAL_DANGER)){
                return availableFireTrucks >= 2;
            }
            return false;
    }

}
