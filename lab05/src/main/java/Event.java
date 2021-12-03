import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Event {
    private final EventType type;
    private final Coordinates coords;
    private final boolean isFalseAlarm;
    Event(double lat, double lon, EventType type, boolean isFalseAlarm) {
        this.coords = new Coordinates(lat,lon);
        this.type = type;
        this.isFalseAlarm = isFalseAlarm;
    }
    Event() {
        this.coords = new Coordinates();
        this.type = randomEventType();
        this.isFalseAlarm = Math.random() <= Probabilities.FALSE_ALARM;
    }

    private EventType randomEventType() {
        return Math.random() <= Probabilities.FIRE ? EventType.FIRE : EventType.LOCAL_DANGER;
    }
}
