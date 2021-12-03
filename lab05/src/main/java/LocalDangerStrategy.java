import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class LocalDangerStrategy extends JRGStrategyWrapper {
    private final int NUMBER_OF_TRUCKS_FOR_FIRE_STRATEGY = 2;
    @Override
    public void execute(Event event) throws UnableToExecuteStrategyException{
        sendTrucks(event, NUMBER_OF_TRUCKS_FOR_FIRE_STRATEGY);
    }
}
