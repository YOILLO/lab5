package lab5.commands;

import lab5.io.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandManager {
    Console console;
    Scanner scanner;
    private List<AbstractCommand> commands= new ArrayList<>();

    public CommandManager(Console cons, Scanner userScan, AbstractCommand[] com){
        console = cons;
        scanner = userScan;

        for (AbstractCommand comm : com)
        {
            commands.add(comm);
        }
    }

    public void ConsoleMod()
    {
        boolean isWork = true;
        while (isWork){
            String[] userCommand = {"", ""};
            userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
            isWork = launchCommand(userCommand);
        }
    }
    private boolean launchCommand(String[] com)
    {
        if (com[0].trim().equals("help"))
        {
            for (AbstractCommand comm : commands) {
                Console.println(comm.getName() + comm.getDescription());
            }
        }
        else {
            for (AbstractCommand comm : commands) {
                if (comm.getName().equals(com[0])) {
                    return comm.execute(com[1]);
                }
            }
            Console.printError("Такой команды нет, проверь help");
        }
        return true;
    }
}
