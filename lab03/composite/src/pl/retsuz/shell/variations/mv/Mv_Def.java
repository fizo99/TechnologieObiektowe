package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Def extends CommandVariation {
    public Mv_Def(ICommandVariation next, ICommand parent) {
        super(next, parent, "([a-zA-Z0-9.\\/_]*\\s[a-zA-Z0-9.\\/_]*)");
    }

    @Override
    public void make(String params) {
        //TODO
        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        try {
            String[] paths = params.split(" ");
            IComposite element = c.findElementByPath(paths[0]);
            IComposite src = element.getParent();
            IComposite dest = c.findElementByPath(paths[1]);
            Composite.moveElement(src, dest, element);
            System.out.println("Przeniesiono " + paths[0] + " do katalogu " + paths[1]);
        } catch (Exception e) {
            System.out.println("Nie udalo sie przeniesc. " + e.getMessage());
        }
    }
}