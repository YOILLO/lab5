package lab5.io;

import lab5.data.Flat;

import java.io.FileReader;
import java.util.List;
import java.util.Vector;

import com.opencsv.bean.CsvToBeanBuilder;

public class FileManager {
    private String FileName;

    public FileManager(String file)
    {
        FileName = file;
    }

    public Vector<Flat> readCollection(){
        try {
            List<Flat> list= new CsvToBeanBuilder(new FileReader(FileName))
                    .withType(Flat.class)
                    .build()
                    .parse();
            return new Vector<Flat>(list);
        }
        catch (java.io.FileNotFoundException e) {
            Console.printError("Ошибка открытия файла.");
        }
        finally {
            Console.printError("Ошибка парсинга.");
        }
        return new Vector<>();
    }
}
