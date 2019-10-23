import java.util.Comparator;
import java.util.*;
/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point  
{
    private double x = 0;
    private double y = 0;
    private Random rando = new Random();
    /**
     * Constructor for objects of class Point
     */
    public Point()
    {
        x = rando.nextDouble()*100;
        y = rando.nextDouble()*100;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
}
