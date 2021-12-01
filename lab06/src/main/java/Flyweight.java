import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Getter
public class Flyweight {
    private String part;
    private List<Flyweight> subparts = new ArrayList();
    private Coordinates coords;

    Flyweight(String part, String[] rest, Coordinates coords) {
        this.part = part;
        if(rest.length == 0){
            this.coords = coords;
        }else{
            String subPart = rest[0];
            String[] newRest = Arrays.copyOfRange(rest, 1, rest.length);

            Optional<Flyweight> probablePart = subparts.stream()
                    .filter(flyweight -> flyweight.getPart().equals(subPart))
                    .findFirst();

            if(probablePart.isPresent()){
                Flyweight flyweight = probablePart.get();
                flyweight.put(newRest, coords);
            }else{
                subparts.add(new Flyweight(subPart, newRest, coords));
            }
        }
    }

    public void put(String[] rest, Coordinates coords) {
        if(rest.length == 0){
            this.coords = coords;
        }else {
            String subPart = rest[0];
            String[] newRest = Arrays.copyOfRange(rest, 1, rest.length);
            Optional<Flyweight> probablePart = subparts.stream()
                    .filter(flyweight -> flyweight.getPart().equals(subPart))
                    .findFirst();

            if(probablePart.isPresent()){
                Flyweight flyweight = probablePart.get();
                flyweight.put(newRest, coords);
            }else{
                subparts.add(new Flyweight(subPart, newRest, coords));
            }
        }
    }
    public Optional<Coordinates> getCoordsFor(String[] rest) {
        if(rest.length == 0){
            return Optional.ofNullable(this.coords);
        } else{
            String subpart = rest[0];
            Optional<Flyweight> flyWeightForSubpart = subparts.stream()
                    .filter(flyweight -> flyweight.getPart().equals(subpart))
                    .findAny()
                    .or(Optional::empty);

            if(flyWeightForSubpart.isPresent()){
                String[] restForSubFlyWeights = Arrays.copyOfRange(rest, 1, rest.length);
                return flyWeightForSubpart.get().getCoordsFor(restForSubFlyWeights);
            }else{
                return Optional.empty();
            }
        }
    }
}
