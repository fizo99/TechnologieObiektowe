package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;

public class Tree extends Command {

    public Tree(IContext ctx, ICommand next) {
        super("tree", ctx, next, null, "Użycie tree <sciezka>");
    }
}
