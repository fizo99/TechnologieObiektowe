package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Def extends CommandVariation {
    public Mv_Def(ICommandVariation next, ICommand parent) {
        super(next, parent, "");
    }

    @Override
    public void make(String params) {
        //TODO
        Composite c = (Composite) (this.getParent().getContext().getCurrent());

        System.out.print(c.tree(" "));

    }
}