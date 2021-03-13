package lab5.commands;

import lab5.data.Flat;
import lab5.io.Console;
import lab5.main.CollectionManager;

public class RemoveGreaterCom extends AbstractCommand{
    Console console;
    CollectionManager collection;

    public RemoveGreaterCom(CollectionManager col, Console cons)
    {
        super("remove_greater", " {element} : удалить из коллекции все элементы, превышающие заданный");
        collection = col;
        console = cons;
    }

    @Override
    public boolean execute(String argument) {
        Flat fl = console.askFlatWithID();
        collection.deleteGreater(fl);
        return true;
    }
}
