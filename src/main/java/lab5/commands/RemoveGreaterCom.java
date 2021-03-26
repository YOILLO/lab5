package lab5.commands;

import lab5.data.Flat;
import lab5.exeptions.EmptyIO;
import lab5.io.Console;
import lab5.main.CollectionManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static lab5.io.Console.printError;
import static lab5.io.Console.println;

/**
 * Remove greatest command
 */
public class RemoveGreaterCom extends AbstractCommand{
    Console console;
    CollectionManager collection;
    Scanner scanner;

    public RemoveGreaterCom(CollectionManager col, Console cons, Scanner sc)
    {
        super("remove_greater", " {element} : удалить из коллекции все элементы, превышающие заданный");
        collection = col;
        console = cons;
        scanner = sc;
    }

    @Override
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
        Flat fl = console.askFlatWithID(id);
        collection.deleteGreater(fl);
        return true;
    }
}
