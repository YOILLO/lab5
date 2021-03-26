package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

/**
 * Remove by id
 */
public class RemoveById extends AbstractCommand{
    CollectionManager collection;

    public RemoveById(CollectionManager col)
    {
        super("remove_by_id", ": удалить элемент из коллекции по его id");
        collection = col;
    }

    @Override
    public boolean execute(String argument) {
        try {
            collection.deleteByID(Integer.parseInt(argument));
        }
        catch (NumberFormatException e)
        {
            Console.println("ID должен быть числом");
        }
        return true;
    }
}
