package lab5.commands;

import lab5.exeptions.EmptyIO;
import lab5.exeptions.WrongFormat;
import lab5.io.Console;
import lab5.main.CollectionManager;
import lab5.data.Flat;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static lab5.io.Console.printError;
import static lab5.io.Console.println;

/**
 * Add if element is less then min in collection
 */
public class AddIfMinCom extends AbstractCommand{
    private CollectionManager collection;
    private Console console;
    private Scanner scanner;

    public AddIfMinCom(CollectionManager col, Console con, Scanner sc)
    {
        super("add_if_min", " {element}: добавить новый элемент, если его значение меньше, чем у наименьшего");
        collection = col;
        console = con;
        scanner = sc;
    }

    public boolean execute(String argument) {
        int id;
        while (true) {
            try {
                println("Ведите район: ");
                String st = scanner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                id = Integer.parseInt(st);
                break;
            } catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            } catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("имя не распознано!");
            }
        }
        Flat testFl = console.askFlatWithID(id);
        if (collection.collectoinSize() == 0 || testFl.compareTo(collection.getFirst())<  0)
        {
            collection.AddToCollection(testFl);
            println("Успешно добавлено.");
            println(testFl.toString());
            return true;
        }
        else {
            printError("Значение комнаты больше, чем значние наименьшего.");
            return true;
        }
    }
}
