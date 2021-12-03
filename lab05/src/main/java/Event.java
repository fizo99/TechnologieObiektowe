import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Event {
    private final String id;
    private final EventType type;
    private final Coordinates coords;
    private final boolean isFalseAlarm;
    Event() {
        this.id = UUID.randomUUID().toString().replace("-","").substring(0,4);
        this.coords = new Coordinates();
        this.type = randomEventType();
        this.isFalseAlarm = Math.random() <= Probabilities.FALSE_ALARM;
    }

    private EventType randomEventType() {
        return Math.random() <= Probabilities.FIRE ? EventType.FIRE : EventType.LOCAL_DANGER;
    }
}
