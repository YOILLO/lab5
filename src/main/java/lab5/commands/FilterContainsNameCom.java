package lab5.commands;

import lab5.exeptions.WrongFormat;
import lab5.io.Console;
import lab5.main.CollectionManager;

import java.util.regex.PatternSyntaxException;

/**
 * Filter by name contains
 */
public class FilterContainsNameCom extends AbstractCommand {
    private CollectionManager collection;

    public FilterContainsNameCom(CollectionManager col)
    {
        super("filter_contains_name"," name: вывести элементы, значение поля name которых содержит заданную подстроку");
        collection = col;
    }

    public boolean execute(String argument) {
        try{
            if (argument.isEmpty()) throw new WrongFormat();
            String info = collection.nameFillteredInfo(argument.trim());
            if (info.isEmpty())
            {
                Console.println("В колекции нет таких имен");
                return true;
            }
            else
            {
                Console.println(info);
                return true;
            }

        } catch (WrongFormat e){
            Console.printError("Неверный формат, забыл имя");
        } catch (PatternSyntaxException e)
        {
            Console.printError("Неверный шаблон");
        }
        return true;
    }
}
