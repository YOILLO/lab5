package lab5.commands;

public class ExitCom extends AbstractCommand{
    public ExitCom()
    {
        super("exit", " завершить программу (без сохранения в файл)");
    }

    public boolean execute(String argument) {
        return false;
    }
}
