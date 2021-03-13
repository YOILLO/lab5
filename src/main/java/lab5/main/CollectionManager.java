package lab5.main;

import lab5.data.Flat;
import lab5.data.House;
import lab5.io.Console;
import lab5.io.FileManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.Collection;

public class CollectionManager {
    private java.util.Vector<Flat> myCollection = new java.util.Vector<>();
    private java.time.LocalDateTime lastInitTime;
    private java.time.LocalDateTime lastSaveTime;
    private FileManager flManager;

    public CollectionManager(FileManager fl) {
        flManager = fl;
        lastSaveTime = null;

        //Load();
    }

    public void Load()
    {
        myCollection = flManager.readCollection();
        lastInitTime = java.time.LocalDateTime.now();
    }

    public void AddToCollection(Flat fl)
    {
        myCollection.add(fl);
    }

    public void ClearCollection()
    {
        myCollection.clear();
    }

    public int generateNextId() {
        if (myCollection.isEmpty()) return 1;
        return myCollection.lastElement().getId() + 1;
    }

    public int collectoinSize()
    {
        return myCollection.size();
    }

    public Flat getFirst(){
        if (myCollection.isEmpty()) return null;
        return myCollection.firstElement();
    }

    public boolean removeLast(){
        if (myCollection.isEmpty()) return false;
        myCollection.remove(myCollection.lastElement());
        return true;
    }

    public  String nameFillteredInfo(String str)
    {
        String info = "";
        Console.println("Ищу по шаблону: "+str);
        for (Flat fl : myCollection)
        {
            if(Pattern.matches(str, fl.getName()))
                info += fl.toString() + "\n";
        }
        return info;
    }
    public void deleteByHouse(House hs)
    {
        for (Flat fl : myCollection)
        {
            if(fl.getHouse().equals(hs))
            {
                myCollection.remove(fl);
                Console.println("Успешно удалено");
                return;
            }
        }
        Console.println("Ненайден такой элемент");
    }

    public void deleteByID(int id)
    {
        for (Flat fl : myCollection)
        {
            if(fl.getId() == id)
            {
                myCollection.remove(fl);
                Console.println("Успешно удалено");
                return;
            }
        }
        Console.println("Ненайден такой элемент");
    }

    public void deleteGreater(Flat flt)
    {
        long i = 0;
        for (Flat fl : myCollection)
        {
            if(fl.getId() > flt.getId())
            {
                myCollection.remove(fl);
                //Console.println("Успешно удалено");
                i++;
            }
        }
        Console.println("Удалено " + i + " объектов");
    }

    public void replace(Flat ft)
    {
        for (Flat fl : myCollection)
        {
            if (fl.getId() == ft.getId())
            {
                Collections.replaceAll(myCollection, fl, ft);
                Console.println("Успешно заменено");
                return;
            }
        }
        Console.println("Нет такого элемента");
    }

    public String printSort()
    {
        Vector<Flat> temp = new Vector<Flat>(myCollection);
        temp.sort(Comparator.comparingInt(Flat::getId));
        String out = "";
        for (Flat fl : temp)
        {
            out += fl.toString();
            out += "\n\n";
        }
        return out;
    }

    public String printNormal()
    {
        String out = "";
        for (Flat fl : myCollection)
        {
            out += fl.toString();
            out += "\n\n";
        }
        return out;
    }

    @Override
    public String toString() {
        return "Тип коллекции = Vector<Flat>\n" + "Время = " + lastInitTime+ "\n" +
                "Количество элементов = " + myCollection.size();
    }
}
