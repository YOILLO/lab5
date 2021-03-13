package lab5.commands;

import lab5.data.Flat;
import lab5.io.Console;
import lab5.main.CollectionManager;

public class UpdateIDCom extends AbstractCommand {
    CollectionManager collection;
    Console console;

    public UpdateIDCom(CollectionManager col, Console cons)
    {
        super("update id", " {element} : обновить значение элемента коллекции, id которого равен заданному");
        collection = col;
        console = cons;
    }

    @Override
    public boolean execute(String argument) {
        Flat flt = console.askFlatWithID();
        collection.replace(flt);
        return true;
    }
}
