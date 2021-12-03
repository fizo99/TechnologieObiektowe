import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SKKM {
    private final List<Thread> processedEvents = new ArrayList<>();
    private final AtomicBoolean hasTrucksAvailable = new AtomicBoolean(true);
    private final long TIME_BETWEEN_EVENTS_MS = 200;

    public void processEvent(Event event) throws UnableToExecuteStrategyException, InterruptedException {
        Thread.sleep(TIME_BETWEEN_EVENTS_MS);

        JRGStrategy strategy = suitableStrategy(event.getType());
        Thread thread = new Thread(() -> {
            try {
                strategy.execute(event);
            } catch (UnableToExecuteStrategyException ex) {
                hasTrucksAvailable.set(false);
            }
        });
        thread.start();
        processedEvents.add(thread);
    }

    public void waitForAllUnitsToComeBackToBase() {
        processedEvents.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public boolean hasTrucksAvailable() {
        return this.hasTrucksAvailable.get();
    }

    private JRGStrategy suitableStrategy(EventType eventType) {
        if (eventType.equals(EventType.FIRE)) {
            return new FireStrategy();//Strategies.FIRE_STRATEGY;
        } else {
            return new LocalDangerStrategy();//Strategies.LOCAL_DANGER_STRATEGY;
        }
    }
}
