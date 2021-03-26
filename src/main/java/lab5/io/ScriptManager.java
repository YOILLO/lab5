package lab5.io;

import java.io.*;

public class ScriptManager {
    BufferedReader bufferedReader;

    public ScriptManager(String file){
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            Console.printError("Ошибка открытия файла");
        }
    }

    public String readLine(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            Console.printError("Ошибка чтения файла");
        }
        return null;
    }
}
