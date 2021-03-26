package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

/**
 * Show collection command
 */
public class ShowCom extends AbstractCommand{
    CollectionManager collection;

    public ShowCom(CollectionManager col){
        super("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        collection = col;
    }

    @Override
    public boolean execute(String argument) {
        Console.println("Колекция:");
        Console.println(collection.printNormal());
        return true;
    }
}
