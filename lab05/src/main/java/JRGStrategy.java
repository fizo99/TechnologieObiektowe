import lombok.Getter;

import java.util.Collections;
import java.util.List;

public interface JRGStrategy {

    void execute(Event event) throws UnableToExecuteStrategyException;
}
