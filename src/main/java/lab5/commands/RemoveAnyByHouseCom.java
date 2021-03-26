package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;

/**
 * Remove one element by house
 */
public class RemoveAnyByHouseCom extends AbstractCommand{
    private CollectionManager collection;
    private Console console;

    public RemoveAnyByHouseCom(CollectionManager col, Console con)
    {
        super("remove_any_by_house", " house : удалить из коллекции один элемент, значение поля house которого эквивалентно заданному");
        collection = col;
        console = con;
    }

    @Override
    public boolean execute(String argument) {
        collection.deleteByHouse(console.askHouse());
        return true;
    }
}
