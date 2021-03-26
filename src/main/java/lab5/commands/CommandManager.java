package lab5.commands;

import lab5.io.Console;
import lab5.io.ScriptManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manager that run all commands
 */
public class CommandManager {
    private Console console;
    private Scanner scanner;
    private List<AbstractCommand> commands= new ArrayList<>();
    private List<String> files = new ArrayList<String>();

    public CommandManager(Console cons, Scanner userScan, AbstractCommand[] com){
        console = cons;
        scanner = userScan;

        files.clear();

        for (AbstractCommand comm : com)
        {
            commands.add(comm);
        }
    }

    /**
     * Console mode
     */
    public void ConsoleMod()
    {
        boolean isWork = true;
        while (isWork){
            String[] userCommand = {"", ""};
            userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
            isWork = launchCommand(userCommand);
        }
    }

    /**
     * Launch console command
     * @param com Command that should be run
     * @return End or not to end
     */
    private boolean launchCommand(String[] com)
    {
        if (com[0].trim().equals("help")) {
            Console.println("help : вывести справку по доступным командам");
            Console.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            for (AbstractCommand comm : commands) {
                Console.println(comm.getName() + comm.getDescription());
            }
        }
        else if (com[0].trim().equals("execute_script")){
            if (!com[1].trim().equals("")) {
                ScripMode(com[1].trim());
                files.clear();
            }
            else{
                Console.printError("Необходим file_name");
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

    /**
     * Launch command for script
     * @param com Command that should be runned
     * @return End or not to end
     */
    private boolean launchScriptCommand(String[] com)
    {
        if (com[0].trim().equals("help")) {
            Console.println("help : вывести справку по доступным командам");
            Console.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
            for (AbstractCommand comm : commands) {
                Console.println(comm.getName() + comm.getDescription());
            }
        }
        else if (com[0].trim().equals("execute_script")){
            if (files.contains(com[1].trim())) {
                Console.printError("Попытка рекурсивно вызвать скрипт");
            }
            else if (com[1].trim().equals("")){
                   Console.printError("Необходим file_name");
            } else {
                ScripMode(com[1].trim());
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

    /**
     * Start script mode
     * @param fileName Script file
     */
    private void ScripMode(String fileName){
        ScriptManager scr = new ScriptManager(fileName.trim());
        if (scr == null){
            Console.printError("Не открывается скрипт");
        }
        else{
            files.add(fileName.trim());
            boolean isWork = true;
            while (isWork){
                String str = scr.readLine();
                if (str == null)
                    break;
                String[] userCommand = {"", ""};
                userCommand = (str + " ").split(" ", 2);
                isWork = launchScriptCommand(userCommand);
            }
        }
    }
}
