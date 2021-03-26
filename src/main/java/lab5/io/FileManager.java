package lab5.io;

import lab5.data.*;

import java.io.*;

import java.time.LocalDate;
import java.util.Vector;


public class FileManager {
    private String FileName;

    public FileManager(String file)
    {
        FileName = file;
    }

    public Vector<Flat> readCollection(){
        try {
            Vector<Flat> buffer = new Vector<Flat>();
            BufferedReader reader = new BufferedReader(new FileReader(FileName));
            String str;
            while ((str = reader.readLine()) != null){
                String[] arr = str.split(";");
                Flat bufFl = new Flat(Integer.parseInt(arr[0].trim()),
                        arr[1].trim(), new Coordinates(Float.parseFloat(arr[2].trim()), Float.parseFloat(arr[3].trim())),
                        LocalDate.parse(arr[4].trim()), Integer.parseInt(arr[5].trim()), Integer.parseInt(arr[6].trim()),
                        Float.parseFloat(arr[7].trim()), Furnish.valueOf(arr[8].trim()), Transport.valueOf(arr[9].trim()),
                        new House(arr[10].trim(), Long.parseLong(arr[11].trim()), Long.parseLong(arr[12].trim())));
                buffer.add(bufFl);

            }
            reader.close();
            Console.println("Коллекция успешно считана");
            return buffer;
        }
        catch (java.io.FileNotFoundException e) {
            Console.printError("Ошибка открытия файла.");
        } catch (IOException e) {
            Console.printError("Ошибка доступа к файлу");
        } catch (NumberFormatException e){
            Console.printError("Ошибка парсинга");
        } catch (NullPointerException e){
            Console.printError("Ошибка парсинга 2");
        }
        return new Vector<>();
    }
    public void WriteCollection(Vector<Flat> coll)
    {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileName));
            for (Flat fl : coll){
                bufferedWriter.write(fl.toCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            Console.println("Успешно записано");
        }catch (IOException e) {
            Console.printError("Ошибка записи файла");
        }
    }
}
