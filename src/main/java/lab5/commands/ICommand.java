package lab5.commands;

public interface ICommand {
    String getDescription();
    String getName();
    boolean execute(String argument);
}
