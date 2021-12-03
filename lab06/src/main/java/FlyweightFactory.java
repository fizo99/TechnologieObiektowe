import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class FlyweightFactory {
    private List<Flyweight> names = new ArrayList<>();

    public Flyweight get(String fullName) {
        String[] parts = FlyweightUtils.convertToParts(fullName);
        String name = FlyweightUtils.extractFirstPart(parts);
        String[] rest = FlyweightUtils.subArrayWithoutFirstPart(parts);

        Flyweight wantedFlyWeight = FlyweightUtils.getExistingFlyweight(name, names)
                .orElseGet(() -> this.newFlyweight(name,rest));

        return wantedFlyWeight.get(rest);
    }

    private Flyweight newFlyweight(String name, String[] rest) {
        Flyweight newFlyWeight = new Flyweight(name, rest);
        names.add(newFlyWeight);
        return newFlyWeight;
    }
}
