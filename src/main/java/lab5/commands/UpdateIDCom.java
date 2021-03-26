package lab5.commands;

import lab5.data.Flat;
import lab5.io.Console;
import lab5.main.CollectionManager;

import static lab5.io.Console.printError;
import static lab5.io.Console.println;

/**
 * Update id command
 */
public class UpdateIDCom extends AbstractCommand {
    CollectionManager collection;
    Console console;

    public UpdateIDCom(CollectionManager col, Console cons)
    {
        super("update", " id {element} : обновить значение элемента коллекции, id которого равен заданному");
        collection = col;
        console = cons;
    }

    @Override
    public boolean execute(String argument) {
        int id;
        if (argument.equals(""))
        {
            printError("Нужен ID");
            return true;
        }
        try{
            id = Integer.parseInt(argument.trim());
        }catch (NumberFormatException e){
            printError("ID долже быть числом");
            return true;
        }
        Flat flt = console.askFlatWithID(id);
        collection.replace(flt);
        return true;
    }
}
