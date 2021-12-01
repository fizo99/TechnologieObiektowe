import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightFactory {
    private Map<String, Flyweight> names = new HashMap<String, Flyweight>();
    public Flyweight get(String name) {
        if(names.containsKey(name)){
            return names.get(name);
        }else{
            String[] parts = name.split(" ");
            Flyweight newFlyweight;
            if(parts.length == 1){
                newFlyweight = new Flyweight(parts[0]);
            }else{
                newFlyweight = new Flyweight(parts[0],parts[1]);
            }
            names.put(name,newFlyweight);
            return newFlyweight;
        }
    }
}
