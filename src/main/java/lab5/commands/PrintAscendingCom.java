package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

public class PrintAscendingCom extends AbstractCommand{
    CollectionManager collection;

    public PrintAscendingCom(CollectionManager col)
    {
        super("print_ascending", ": вывести элементы коллекции в порядке возрастания");
        collection = col;
    }

    @Override
    public boolean execute(String argument) {
        Console.println("Отсортированная коллекция:");
        Console.println(collection.printSort());
        return true;
    }
}
