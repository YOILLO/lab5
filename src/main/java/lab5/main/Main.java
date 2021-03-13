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
        Collection collection = new Collection(fileManager);
        Scanner scanner = new Scanner(System.in, Charset.forName("cp1251"));
        Console console = new Console(scanner, collection);
        CommandManager commandManager = new CommandManager(console, scanner, new AddCom(collection, console),
                new AddIfMinCom(collection, console), new ClearCom(collection),
                new ExitCom(), new FilterContainsNameCom(collection));
        commandManager.ConsoleMod();
    }
}
