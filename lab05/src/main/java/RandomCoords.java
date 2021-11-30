public class RandomCoords {
    public static double randomLat() {
        return randomCoord(49.95855025648944, 50.154564013341734);
    }
    public static double randomLon() {
        return randomCoord(19.688292482742394, 20.02470275868903);
    }
    private static double randomCoord(double min,double max) {
        return min + Math.random() * (max - min);
    }
}
