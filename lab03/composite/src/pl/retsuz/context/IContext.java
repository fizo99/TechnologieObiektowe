package pl.retsuz.context;

import pl.retsuz.filesystem.IComposite;

public interface IContext {
    IComposite getCurrent();

    void setCurrent(IComposite current);
}
