package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;

public class Mv extends Command {

    public Mv(IContext ctx, ICommand next) {
        //TODO
        super("mv", ctx, next, null, "Użycie mv <sciezka>");
    }
}
