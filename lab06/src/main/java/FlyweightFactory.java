import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlyweightFactory {
    private List<Flyweight> names = new ArrayList<>();

    public Optional<Coordinates> get(String fullName) {
        String[] parts = convertToParts(fullName);
        String name = extractNameFromParts(parts);
        Optional<Flyweight> flyWeightForName = getProbableFlyweightForName(name);

        if (flyWeightForName.isPresent()) {
            Flyweight wantedFlyWeight = flyWeightForName.get();
            String[] rest = subArrayWithoutName(parts);
            return wantedFlyWeight.getCoordsFor(rest);
        } else {
            return Optional.empty();
        }
    }

    public void put(String fullName, Coordinates coords) {
        String[] parts = convertToParts(fullName);
        String[] rest = subArrayWithoutName(parts);
        String name = extractNameFromParts(parts);

        Optional<Flyweight> probableName = getProbableFlyweightForName(name);
        probableName.ifPresentOrElse(
                        flyweight -> flyweight.put(rest, coords),
                        () -> names.add(new Flyweight(name, rest, coords)));
    }

    private Optional<Flyweight> getProbableFlyweightForName(String name) {
        return names.stream()
                .filter(flyweight -> flyweight.getPart().equals(name))
                .findFirst();
    }

    private String[] subArrayWithoutName(String[] parts) {
        return Arrays.copyOfRange(parts, 1, parts.length);
    }

    private String[] convertToParts(String fullName) {
        return fullName.split(" ");
    }

    private String extractNameFromParts(String[] parts) {
        return parts[0];
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
