package lab5.data;

public class Coordinates {
    private float x;
    private float y;

    public Coordinates(float X, float Y)
    {
        x = X;
        y = Y;
    }

    public  float GetX()
    {
        return x;
    }

    public float GetY()
    {
        return y;
    }

    @Override
    public String toString() {
        return  "x=" + x +
                ", y=" + y;
    }
}
