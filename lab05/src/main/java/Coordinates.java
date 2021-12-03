import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Coordinates {
    public final double lat;
    public final double lon;

    Coordinates() {
        this.lat = randomLat();
        this.lon = randomLon();
    }

    public static double distance(Coordinates source, Coordinates destination) {
        double theta = source.getLon() - destination.getLon();
        double dist = Math.sin(deg2rad(source.getLat())) * Math.sin(deg2rad(destination.getLat())) + Math.cos(deg2rad(source.getLat())) * Math.cos(deg2rad(destination.getLat())) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return dist * 1.609344;
    }

    public static double randomLat() {
        return randomCoord(49.95855025648944, 50.154564013341734);
    }

    public static double randomLon() {
        return randomCoord(19.688292482742394, 20.02470275868903);
    }

    private static double randomCoord(double min, double max) {
        return min + Math.random() * (max - min);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    @Override
    public String toString() {
        return "(" + lat + "," + lon + ")";
    }
}
