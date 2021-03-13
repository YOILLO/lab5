package lab5.main;

import lab5.commands.*;
import lab5.io.Console;
import lab5.io.FileManager;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        FileManager fileManager = new FileManager("a");
        CollectionManager collection = new CollectionManager(fileManager);
        Scanner scanner = new Scanner(System.in, Charset.forName("cp1251"));
        Console console = new Console(scanner, collection);
        CommandManager commandManager = new CommandManager(console, scanner,
                new AbstractCommand[]{new AddCom(collection, console),
                new AddIfMinCom(collection, console), new ClearCom(collection),
                new ExitCom(), new FilterContainsNameCom(collection),
                new RemoveAnyByHouseCom(collection, console), new PrintAscendingCom(collection),
                new InfoCom(collection), new ShowCom(collection),
                new RemoveLastCom(collection), new RemoveById(collection),
                new RemoveGreaterCom(collection, console), new UpdateIDCom(collection, console)});
        commandManager.ConsoleMod();
    }
}
