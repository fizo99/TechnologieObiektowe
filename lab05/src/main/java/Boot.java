import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.logging.Logger;

public class Boot {
    private static OutgoingEvents events = new OutgoingEvents();
    private static SKKM skkm = new SKKM();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        Iterator<Event> it = events.iterator();
        while (it.hasNext() && skkm.getHaveEnoughFireTrucks().get()) {
            Event event = it.next();
            try {
                skkm.processEvent(event);
            } catch (InterruptedException e) {

            }
        }
        Logger.getGlobal().info("No more cars available. Waiting for jrgs to come back to bases..." );
        Logger.getGlobal().info(gson.toJson(JRGStrategyWrapper.JRGS));
        skkm.getProcessedEvents().forEach(thread -> {
            try {
                thread.join();
            }catch (InterruptedException ex){

            }
        });
    }
}
