import java.util.List;
import java.util.Map;

public class Boot {
    private static FlyweightFactory factory = new FlyweightFactory();
    private static Map<String,Coordinates> fullNames = Map.of(
            "Zbigniew Ziobro", new Coordinates(0.0,0.0),
            "Zbigniew Ziobro Maria",new Coordinates(1.0,1.0),
            "Zbigniew Kowalski",new Coordinates(2.0,2.0),
            "Janusz Kowalski",new Coordinates(3.0,3.0),
            "Janusz Kowalski Nowak",new Coordinates(4.0,4.0),
            "Krzysztof Nowak",new Coordinates(5.0,5.0)
    );
    public static void main(String[] args) {
        fullNames.forEach((name,coords) -> {
            factory.put(name,coords);
        });
        fullNames.forEach((name,coords) -> {
            factory.get(name)
                    .ifPresentOrElse(coo -> {
                        System.out.println(String.format("%s,%s",name,coo));
                    }, () -> {
                        System.out.println("NO COORDS FOR " + name);
                    });
        });
    }
}
