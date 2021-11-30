import java.util.Comparator;

public class DistanceComparator implements Comparator<JRG> {
    private Event event;
    DistanceComparator(Event event){
        this.event = event;
    }

    @Override
    public int compare(JRG firstJRG, JRG secondJRG) {
        double eventLat = event.getLat();
        double eventLon = event.getLon();
        double distanceFirstJRG = Coords.distance(firstJRG.getLat(),firstJRG.getLon(), eventLat, eventLon, 'K');
        double distanceSecondJRG = Coords.distance(secondJRG.getLat(),secondJRG.getLon(), eventLat, eventLon, 'K');
        System.out.println(String.format("%s,%s,%s,%s,%s",firstJRG.getLat(),firstJRG.getLon(), eventLat, eventLon,distanceFirstJRG));
        if(distanceFirstJRG < distanceSecondJRG)
            return -1;
        else if(distanceFirstJRG == distanceSecondJRG)
            return 0;
        else
            return 1;
    }
}
