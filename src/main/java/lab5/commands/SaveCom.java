package lab5.commands;

import lab5.main.CollectionManager;

public class SaveCom extends AbstractCommand{
    CollectionManager collection;

    public SaveCom(CollectionManager coll)
    {
        super("save", " : сохранить коллекцию в файл");
        collection = coll;
    }

    @Override
    public boolean execute(String argument) {
        collection.Save();
        return true;
    }
}
