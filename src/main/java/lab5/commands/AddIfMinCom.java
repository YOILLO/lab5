package lab5.commands;

import lab5.io.Console;
import lab5.main.CollectionManager;
import lab5.data.Flat;

public class AddIfMinCom extends AbstractCommand{
    private CollectionManager collection;
    private Console console;

    public AddIfMinCom(CollectionManager col, Console con)
    {
        super("add_if_min", " {element}: добавить новый элемент, если его значение меньше, чем у наименьшего");
        collection = col;
        console = con;
    }

    public boolean execute(String argument) {
        Flat testFl = console.askFlatWithID();
        if (collection.collectoinSize() == 0 || testFl.compareTo(collection.getFirst())<  0)
        {
            collection.AddToCollection(testFl);
            Console.println("Успешно добавлено.");
            Console.println(testFl.toString());
            return true;
        }
        else {
            Console.printError("Значение комнаты больше, чем значние наименьшего.");
            return true;
        }
    }
}
