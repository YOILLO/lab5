package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

/**
 * Remove last command
 */
public class RemoveLastCom extends AbstractCommand{
    private CollectionManager collection;

    public RemoveLastCom(CollectionManager col)
    {
        super("remove_last", ": удалить последний элемент из коллекции");
        collection = col;
    }

    @Override
    public boolean execute(String argument) {
        if(collection.removeLast())
            Console.println("Последний элемент удален");
        else
            Console.println("Коллекция пуста");
        return true;
    }
}
