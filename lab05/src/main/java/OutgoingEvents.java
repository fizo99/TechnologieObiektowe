import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class OutgoingEvents {
    private static final int NUMBER_OF_EVENTS = 10;
    private final List<Event> events;

    OutgoingEvents() {
        this.events = initEvents();
    }

    public Iterator<Event> iterator() {
        return new OutgoingEventsIterator();
    }

    private List<Event> initEvents() {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_EVENTS; i++) {
            events.add(new Event());
        }
        return events;
    }

    private class OutgoingEventsIterator implements Iterator<Event> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex != events.size();
        }

        @Override
        public Event next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Next event not available");
            }
            int prevIndex = currentIndex;
            currentIndex++;
            return events.get(prevIndex);
        }
    }

}
