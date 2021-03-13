package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

public class InfoCom extends AbstractCommand{
    CollectionManager collection;

    public InfoCom(CollectionManager col)
    {
        super("info", ": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        collection = col;
    }

    @Override
    public boolean execute(String argument) {
        Console.println("Инфрмация о коллекции:");
        Console.println(collection.toString());
        return true;
    }
}
