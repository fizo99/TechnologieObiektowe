package pl.retsuz.shell.gen;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.variations.gen.ICommandVariation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command implements ICommand {
    Pattern generalPattern;
    ICommandVariation _default;
    private final String prefix;
    private final IContext context;
    private final ICommand next;
    private final String man;

    public Command(String prefix, IContext ctx, ICommand next, ICommandVariation def, String info) {
        this.context = ctx;
        this.prefix = prefix;
        this.next = next;
        this.generalPattern = Pattern.compile(prefix + " *([a-zA-Z0-9.l\\/_]*)");
        this._default = def;
        this.man = info;
    }

    public void setGeneralPattern(String pattern) {
        this.generalPattern = Pattern.compile(prefix + pattern);
    }

    public ICommandVariation get_default() {
        return _default;
    }

    public void set_default(ICommandVariation _default) {
        this._default = _default;
    }

    private boolean checkPrefix(String command) {
        Matcher m = generalPattern.matcher(command);
        return m.matches();
    }

    public void perform(String command) throws Exception {
        if (!checkPrefix(command)) {
            if (this.next != null)
                this.next.perform(command);
            else throw new Exception("Polecenie nie istnieje.");
        } else {
            Matcher m = generalPattern.matcher(command);
            String params = "";

            if (m.find()) {
                params = m.group(1);
            }
            this._default.processVariation(params);
        }
    }

    public String man() {
        return this.man;
    }

    public IContext getContext() {
        return this.context;
    }
}
