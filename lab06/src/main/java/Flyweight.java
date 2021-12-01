import java.util.ArrayList;
import java.util.List;

public class Flyweight {
    private String part;
    private List<Flyweight> subparts = new ArrayList();
    Flyweight(String part) {
        this.part = part;
    }
    Flyweight(String part, String subpart) {
        this.part = part;
        String[] subparts = subpart.split("-");
        if(subparts.length == 1){
            this.subparts.add(new Flyweight(subparts[0]));
        }else{
            this.subparts.add(new Flyweight(subparts[0],subparts[1]));
        }
    }
}
