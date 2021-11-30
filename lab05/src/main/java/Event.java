import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Event {
    private final EventType type;
    private final double lat;
    private final double lon;
    private final boolean isFalseAlarm;
    Event(double lat, double lon, EventType type, boolean isFalseAlarm) {
        this.lat = lat;
        this.lon = lon;
        this.type = type;
        this.isFalseAlarm = isFalseAlarm;
    }
    Event() {
        this.lat = RandomCoords.randomLat();
        this.lon = RandomCoords.randomLon();
        this.type = randomEventType();
        this.isFalseAlarm = Math.random() <= Probabilities.FALSE_ALARM;
    }

    private EventType randomEventType() {
        return Math.random() <= Probabilities.FIRE ? EventType.FIRE : EventType.LOCAL_DANGER;
    }
}
