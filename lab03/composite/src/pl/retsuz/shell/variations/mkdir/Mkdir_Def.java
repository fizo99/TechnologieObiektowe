package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_Def extends CommandVariation {
    public Mkdir_Def(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        //TODO
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        Composite directory = new Composite();
        directory.setName(params);
        try {
            c.addElement(directory);
            System.out.println("Stworzono katalog " + params);
        } catch (Exception e) {
            System.out.println("Nie można stworzyć katalogu. " + e.getMessage());
        }
    }
}