package pl.retsuz.shell.variations.gen;

import pl.retsuz.shell.gen.ICommand;

public interface ICommandVariation {
    void processVariation(String params) throws Exception;

    void setParent(ICommand command);
}
