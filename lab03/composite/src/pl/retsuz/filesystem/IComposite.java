package pl.retsuz.filesystem;

public interface IComposite {
    String getName();

    void setName(String name);

    IComposite getParent();

    void setParent(IComposite param);

    String getPath();
}
