import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Flyweight {
    private String part;
    @Setter
    private Coordinates coords;
    private List<Flyweight> subparts = new ArrayList();
    Flyweight(String part, String[] rest) {
        this.part = part;
        this.updateSubParts(rest);
    }
    private void updateSubParts(String[] rest) {
        if(rest.length != 0) {
            String part = FlyweightUtils.extractFirstPart(rest);
            String[] newRest = FlyweightUtils.subArrayWithoutFirstPart(rest);

            FlyweightUtils.getExistingFlyweight(part, subparts)
                    .ifPresentOrElse(
                            flyweight -> flyweight.updateSubParts(newRest),
                            () -> this.createNewFlyweight(part,newRest)
                    );
        }
    }
    public Flyweight get(String[] rest) {
        if(rest.length == 0){
            return this;
        } else{
            String part = FlyweightUtils.extractFirstPart(rest);
            String[] newRest = FlyweightUtils.subArrayWithoutFirstPart(rest);
            Flyweight flyWeightForSubpart = FlyweightUtils.getExistingFlyweight(part, subparts)
                    .orElseGet(() -> this.createNewFlyweight(part, newRest));

            return flyWeightForSubpart.get(newRest);
        }
    }

    private Flyweight createNewFlyweight(String part, String[] rest) {
        Flyweight newFlyWeight = new Flyweight(part, rest);
        subparts.add(newFlyWeight);
        return newFlyWeight;
    }
}
