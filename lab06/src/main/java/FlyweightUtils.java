import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlyweightUtils {
    public static String[] subArrayWithoutFirstPart(String[] parts) {
        return Arrays.copyOfRange(parts, 1, parts.length);
    }

    public static String[] convertToParts(String fullName) {
        return fullName.split(" ");
    }

    public static String extractFirstPart(String[] parts) {
        return parts[0];
    }

    public static Optional<Flyweight> getExistingFlyweight(String part, List<Flyweight> subParts) {
        return subParts.stream()
                .filter(flyweight -> flyweight.getPart().equals(part))
                .findFirst();
    }
}
