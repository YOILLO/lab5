package lab5.data;

public class House {
    private String name; //Поле не может быть null
    private long year; //Значение поля должно быть больше 0
    private long numberOfFloors; //Значение поля должно быть больше 0

    public House(String nm, long ya, long numOF)
    {
        name = nm;
        year = ya;
        numberOfFloors = numOF;
    }

    public String getName() {
        return name;
    }

    public long getYear() {
        return year;
    }

    public long getNumberOfFloors() {
        return numberOfFloors;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", year=" + year +
                ", numberOfFloors=" + numberOfFloors;
    }
}
