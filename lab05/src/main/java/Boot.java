import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;

public class Boot {
    private static OutgoingEvents events = new OutgoingEvents();
    private static SKKM skkm = new SKKM();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final Logger log = Logger.getLogger(Boot.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Iterator<Event> it = events.iterator();
        while (it.hasNext() && skkm.hasTrucksAvailable()) {
            Event event = it.next();
            skkm.processEvent(event);
        }

        if(!it.hasNext()){
            log.info("All events handled! Waiting for firetrucks to come back to bases..." );
        }else {
            log.info("No more cars available. Waiting for firetrucks to come back to bases..." );
            log.debug("FireTrucks state at the end:\n" + gson.toJson(JRGStrategyWrapper.JRGS));
        }

        skkm.waitForAllUnitsToComeBackToBase();
    }
}
