package lab5.commands;

import lab5.exeptions.WrongFormat;
import lab5.io.Console;
import lab5.main.Collection;

import java.sql.Wrapper;

public class FilterContainsNameCom extends AbstractCommand {
    private Collection collection;

    public FilterContainsNameCom(Collection col)
    {
        super("filter_contains_name"," name: вывести элементы, значение поля name которых содержит заданную подстроку");
        collection = col;
    }

    public boolean execute(String argument) {
        try{
            if (argument.isEmpty() || argument.isBlank()) throw new WrongFormat();
            String info = collection.nameFillteredInfo(argument);
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
        }
        return true;
    }
}
