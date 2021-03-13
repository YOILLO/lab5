package lab5.commands;

import lab5.data.Flat;
import lab5.io.Console;
import lab5.io.FileManager;
import lab5.main.Collection;

import java.time.LocalDateTime;

public class AddCom extends AbstractCommand{
    private Collection collection;
    private Console console;

    public AddCom(Collection col, Console con)
    {
        super("add", "{element}: Добавить новый элемент в коллекцию");
        collection = col;
        console = con;
    }

    public boolean execute(String argument) {
        Flat fl = console.askFlat();
        Console.println(fl.toString());
        collection.AddToCollection(fl);

        return true;
    }
}
