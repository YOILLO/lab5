package lab5.data;

public class Flat {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer area; //Значение поля должно быть больше 0
    private Integer numberOfRooms; //Максимальное значение поля: 17, Значение поля должно быть больше 0
    private Float price; //Максимальное значение поля: 191928932, Значение поля должно быть больше 0
    private Furnish furnish; //Поле не может быть null
    private Transport transport; //Поле может быть null
    private House house; //Поле не может быть null

    public Flat (int Id, String nm, Coordinates cd, java.time.LocalDate crD, Integer ea, Integer nOR, Float pc, Furnish fsh,
                 Transport ts, House hs)
    {
        id = Id;
        name = nm;
        coordinates = cd;
        creationDate = crD;
        area = ea;
        numberOfRooms = nOR;
        price = pc;
        furnish = fsh;
        transport = ts;
        house = hs;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Coordinates getCoordinates()
    {
        return coordinates;
    }
    public java.time.LocalDate getCreationDate()
    {
        return creationDate;
    }
    public Integer getArea()
    {
        return area;
    }
    public Integer getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public Float getPrice()
    {
        return price;
    }
    public Furnish getFurnish()
    {
        return furnish;
    }
    public Transport getTransport()
    {
        return transport;
    }
    public House getHouse()
    {
        return house;
    }

    public int compareTo(Flat flat)
    {
        return Integer.compare(id, flat.getId());
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", area=" + area +
                ", numberOfRooms=" + numberOfRooms +
                ", price=" + price +
                ", furnish=" + furnish +
                ", transport=" + transport +
                ", house=" + house +
                '}';
    }
}
