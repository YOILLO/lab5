package lab5.io;

import lab5.commands.CommandManager;
import lab5.data.*;
import lab5.exeptions.EmptyIO;
import lab5.exeptions.WrongFormat;
import lab5.main.Collection;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Console {
    private Scanner userScaner;
    private Collection myCollectoin;

    public Console(Scanner sc, Collection collection)
    {
        userScaner = sc;
        myCollectoin = collection;
    }

    public Flat askFlat()
    {
        int Id = myCollectoin.generateNextId();
        println("ID = " + Integer.toString(Id));

        String name = null;
        while (name == null) {
            try{
                println("Ведите имя: ");
                String nm = userScaner.nextLine().trim();
                if (nm == null) throw new EmptyIO();
                if (nm.equals("")) throw new EmptyIO();
                name = nm;
            }
            catch (EmptyIO e)
            {
                printError("Строка не может быть пустой");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        float x;
        while (true) {
            try{
                println("Ведите кординату X: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (name.equals("")) throw new EmptyIO();
                x = Float.parseFloat(st);
                break;
            }
            catch (EmptyIO e)
            {
                printError("Строка не может быть пустой");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        float y;
        while (true) {
            try{
                println("Ведите кординату Y: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                y = Float.parseFloat(st);
                break;
            }
            catch (EmptyIO e)
            {
                printError("Строка не может быть пустой");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        Integer erea;
        while (true) {
            try {
                println("Ведите район: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                erea = Integer.parseInt(st);
                if (erea < 0) throw new WrongFormat();
                break;
            } catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            } catch (WrongFormat e){
                printError("Неверный формат, число должно быть больше 0");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        Integer numberOfRooms;
        while (true) {
            try {
                println("Ведите количество комнат: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                numberOfRooms = Integer.parseInt(st);
                if (numberOfRooms < 0 || numberOfRooms > 17) throw new WrongFormat();
                break;
            } catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            } catch (WrongFormat e) {
                printError("Неверный формат, число должно быть больше 0 и меньше 17");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        float price;
        while (true) {
            try{
                println("Ведите цену: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                price = Float.parseFloat(st);
                if (price < 0 || price > 191928932) throw new WrongFormat();
                break;
            }
            catch (EmptyIO e)
            {
                printError("Строка не может быть пустой");
            }catch (WrongFormat e){
                printError("Неверный формат, число должно быть больше 0 и меньше 191928932");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        Furnish furnish;
        while (true) {
            try{
                println("Ведите вид мебели, варианты:");
                println(Furnish.nameList());
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                furnish = Furnish.valueOf(st);
                break;
            }
            catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            }catch (NoSuchElementException exception) {
                printError("Категория не распознана!");
            }catch (IllegalArgumentException exception) {
                printError("Категории нет в списке!");
            }
        }

        Transport transport;
        while (true) {
            try{
                println("Ведите вид транспорта, варианты:");
                println(Transport.nameList());
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                transport = Transport.valueOf(st);
                break;
            }
            catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            }catch (NoSuchElementException exception) {
                printError("Категория не распознана!");
            }catch (IllegalArgumentException exception) {
                printError("Категории нет в списке!");
            }
        }

        String houseName = null;
        while (houseName == null) {
            try{
                println("Ведите имя дома: ");
                String nm = userScaner.nextLine().trim();
                if (nm == null) throw new EmptyIO();
                if (nm.equals("")) throw new EmptyIO();
                houseName = nm;
            }
            catch (EmptyIO e)
            {
                printError("Строка не может быть пустой");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        long year;
        while (true) {
            try {
                println("Ведите возраст дома: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                year = Long.parseLong(st);
                if (year < 0) throw new WrongFormat();
                break;
            } catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            } catch (WrongFormat e){
                printError("Неверный формат, число должно быть больше 0");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }

        long numberOfFlors;
        while (true) {
            try {
                println("Ведите количество этажей: ");
                String st = userScaner.nextLine().trim();
                if (st == null) throw new EmptyIO();
                if (st.equals("")) throw new EmptyIO();
                numberOfFlors = Long.parseLong(st);
                if (numberOfFlors < 0) throw new WrongFormat();
                break;
            } catch (EmptyIO e) {
                printError("Строка не может быть пустой");
            } catch (WrongFormat e){
                printError("Неверный формат, число должно быть больше 0");
            }catch (NumberFormatException exception) {
                printError("Должно быть представлено числом!");
            }catch (NoSuchElementException exception) {
                printError("Имя не распознано!");
            }
        }


        return new Flat(Id, name, new Coordinates(x,y), java.time.LocalDate.now(), erea,
                numberOfRooms, price, furnish, transport, new House(houseName, year, numberOfFlors));
    }

    public static void printError(String msg)
    {
        System.out.println("Err: " + msg);
    }

    public static void println(String msg){
        System.out.println(msg);
    }

}
