package pl.retsuz.shell.gen;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public interface ICommand {
    void perform(String command) throws Exception;

    String man();

    IContext getContext();

    ICommandVariation get_default();

    void set_default(ICommandVariation _default);
}
