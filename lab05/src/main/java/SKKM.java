import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SKKM {
    @Getter
    private final List<Thread> processedEvents = new ArrayList<>();
    @Getter
    private final AtomicBoolean haveEnoughFireTrucks = new AtomicBoolean(true);

    public void processEvent(Event event) throws UnableToExecuteStrategyException, InterruptedException {
        Thread.sleep(100);

        JRGStrategy strategy = suitableStrategy(event.getType());
        Thread thread = new Thread(() -> {
            try {
                strategy.execute(event);
            } catch (UnableToExecuteStrategyException ex) {
                haveEnoughFireTrucks.set(false);
            }
        });
        thread.start();
        processedEvents.add(thread);
    }

    private JRGStrategy suitableStrategy(EventType eventType) {
        if(eventType.equals(EventType.FIRE)){
            return new FireStrategy();//Strategies.FIRE_STRATEGY;
        }else {
            return new LocalDangerStrategy();//Strategies.LOCAL_DANGER_STRATEGY;
        }
    }
}
