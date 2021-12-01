import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlyweightFactory {
    private List<Flyweight> names = new ArrayList<>();

    public Optional<Coordinates> get(String fullName) {
        String[] parts = fullName.split(" ");
        String name = parts[0];
        Optional<Flyweight> flyWeightForName = names.stream()
                .filter(flyweight -> flyweight.getPart().equals(name))
                .findAny()
                .or(Optional::empty);

        if (flyWeightForName.isPresent()) {
            Flyweight wantedFlyWeight = flyWeightForName.get();
            String[] rest = Arrays.copyOfRange(parts, 1, parts.length);
            return wantedFlyWeight.getCoordsFor(rest);
        } else {
            return Optional.empty();
        }
    }

    public void put(String fullName, Coordinates coords) {
        String[] parts = fullName.split(" ");

        String name = parts[0];
        String[] rest = Arrays.copyOfRange(parts, 1, parts.length);

        Optional<Flyweight> probableName = names
                .stream()
                .filter(flyweight -> flyweight.getPart().equals(name))
                .findFirst();

        if (probableName.isPresent()) {
            Flyweight flyweight = probableName.get();
            flyweight.put(rest, coords);
        } else {
            names.add(new Flyweight(name, rest, coords));
        }
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
