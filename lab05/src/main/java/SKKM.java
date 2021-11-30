import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SKKM {
    private static List<JRG> jrgs = List.of(
            new JRG("JRG-1",50.06041681642017, 19.9430921693129),
            new JRG("JRG-2",50.034216415244586, 19.935570792595158),
            new JRG("JRG-3",50.07679870745459, 19.888040504154123),
            new JRG("JRG-4",50.037853998244394, 20.00585202880808),
            new JRG("JRG-5",50.09231965995491, 19.92211985579486),
            new JRG("JRG-6",50.019370844510384, 20.015670999437578),
            new JRG("JRG-7",50.094213222124935, 19.97744472695901),
            new JRG("JRG-Szkoła-Aspirantów-PSP",50.07833305675096, 20.03240462235691),
            new JRG("JRG-Skawina",49.97736182717588, 19.800510652229956),
            new JRG("LSP-Lotnisko-Balice",50.073351226659994, 19.78585895394286)
    );

    private static OutgoingEvents events = new OutgoingEvents();

    public static void run() {
        Iterator<Event> it = events.iterator();
        while(it.hasNext()){
            Event event = it.next();
            List<JRG> jrgs = sortedJRGS(event);
            if(jrgs.size() == 0) {
                System.out.println("END");
            }else{
                jrgs.get(0).triggerEvent(event.getType());
            }
        }
    }

    private static List<JRG> sortedJRGS(Event event) {
        double eventLat = event.getLat();
        double eventLon = event.getLon();
        return jrgs.stream()
                .filter(jrg -> {
                    int availableFireTrucks = (int) jrg.getFireTrucks()
                            .stream()
                            .filter(fireTruck -> fireTruck.getFireTruckState() instanceof Free)
                            .count();
                    if(event.getType().equals(EventType.FIRE)){
                        return availableFireTrucks >= 3;
                    }else if(event.getType().equals(EventType.LOCAL_DANGER)){
                        return availableFireTrucks >= 2;
                    }
                    return false;
                })
                .sorted((firstJRG, secondJRG) -> {
                    double distanceFirstJRG = distance(firstJRG.getLat(),firstJRG.getLon(), eventLat, eventLon, 'K');
                    double distanceSecondJRG = distance(secondJRG.getLat(),secondJRG.getLon(), eventLat, eventLon, 'K');
                    System.out.println(String.format("%s,%s,%s,%s,%s",firstJRG.getLat(),firstJRG.getLon(), eventLat, eventLon,distanceFirstJRG));
                    if(distanceFirstJRG < distanceSecondJRG) return -1;
                    else if(distanceFirstJRG == distanceSecondJRG) return 0;
                    else return 1;
                }).collect(Collectors.toList());
    }

    private static double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
