package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;

public class More extends Command {
    public More(IContext ctx, ICommand next) {
        super("more", ctx, next, null, "Użycie more <sciezka>");
    }
}