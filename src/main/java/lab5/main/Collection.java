package lab5.main;

import lab5.data.Flat;
import lab5.io.Console;
import lab5.io.FileManager;

import java.text.CollationElementIterator;
import java.util.ConcurrentModificationException;
import java.util.regex.Pattern;

public class Collection {
    private java.util.Vector<Flat> Collection = new java.util.Vector<>();
    private java.time.LocalDateTime lastInitTime;
    private java.time.LocalDateTime lastSaveTime;
    private FileManager flManager;

    public Collection(FileManager fl) {
        flManager = fl;
        lastSaveTime = null;

        //Load();
    }

    public void Load()
    {
        Collection = flManager.readCollection();
        lastInitTime = java.time.LocalDateTime.now();
    }

    public void AddToCollection(Flat fl)
    {
        Collection.add(fl);
    }

    public void ClearCollection()
    {
        Collection.clear();
    }

    public int generateNextId() {
        if (Collection.isEmpty()) return 1;
        return Collection.lastElement().getId() + 1;
    }

    public int collectoinSize()
    {
        return Collection.size();
    }

    public Flat getFirst(){
        if (Collection.isEmpty()) return null;
        return Collection.firstElement();
    }

    public  String nameFillteredInfo(String str)
    {
        String info = "";
        Console.println("Ищу по шаблону: "+str);
        for (Flat fl : Collection)
        {
            if(Pattern.matches(str, fl.getName()))
                info += fl.toString() + "\n";
        }
        return info;
    }
}
