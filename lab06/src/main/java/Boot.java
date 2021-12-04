import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Boot {
    private static Map<String, Coordinates> fullNames = Map.of(
            "Zbigniew Ziobro", new Coordinates(0.0, 0.0),
            "Zbigniew Ziobro Maria", new Coordinates(1.0, 1.0),
            "Zbigniew Kowalski", new Coordinates(2.0, 2.0),
            "Janusz Kowalski", new Coordinates(3.0, 3.0),
            "Janusz Kowalski Nowak", new Coordinates(4.0, 4.0),
            "Krzysztof Nowak", new Coordinates(5.0, 5.0)
    );

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        fillFactory(factory);

        Proxy proxy = new Proxy(factory);
        UI ui = new UI(proxy);

        ui.run();
    }

    private static void fillFactory(FlyweightFactory factory) {
        fullNames.forEach((name, coords) -> factory.get(name.toUpperCase()).setCoords(coords));
    }
}
