package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

/**
 * Clear collection command
 */
public class ClearCom extends AbstractCommand{
    private CollectionManager collection;

    public ClearCom(CollectionManager col)
    {
        super("clear", " очистить коллекцию");
        collection = col;
    }

    public boolean execute(String argument) {
        collection.ClearCollection();
        Console.println("Успешно очищено!");
        return true;
    }
}
