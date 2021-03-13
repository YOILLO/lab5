package lab5.commands;

import lab5.io.Console;
import lab5.main.Collection;

public class ClearCom extends AbstractCommand{
    private Collection collection;

    public ClearCom(Collection col)
    {
        super("clear", "очистить коллекцию");
        collection = col;
    }

    public boolean execute(String argument) {
        collection.ClearCollection();
        Console.println("Успешно очищено!");
        return true;
    }
}
