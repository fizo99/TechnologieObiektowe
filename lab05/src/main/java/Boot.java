public class Boot {
    private static OutgoingEvents events = new OutgoingEvents();
    private static SKKM skkm = new SKKM();

    public static void main(String[] args) throws Exception {
        Iterator<Event> it = events.iterator();
        while (it.hasNext()) {
            Event event = it.next();
            skkm.processEvent(event);
        }
    }
}
