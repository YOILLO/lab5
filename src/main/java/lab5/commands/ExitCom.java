package lab5.commands;

import lab5.io.Console;
import lab5.main.Collection;

public class ExitCom extends AbstractCommand{
    public ExitCom()
    {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    public boolean execute(String argument) {
        return false;
    }
}
