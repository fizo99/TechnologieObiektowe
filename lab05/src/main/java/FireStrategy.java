import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FireStrategy extends JRGStrategyWrapper {
    private final int NUMBER_OF_TRUCKS_FOR_FIRE_STRATEGY = 3;
    @Override
    public void execute(Event event) throws UnableToExecuteStrategyException{
        // TODO implement strategy for fire
        sendTrucks(event, NUMBER_OF_TRUCKS_FOR_FIRE_STRATEGY);
    }

}
