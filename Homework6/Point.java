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
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Random rando = new Random();
    private ArrayList Xcoordinates = new ArrayList();
    private ArrayList Ycoordinates = new ArrayList();
    /**
     * Constructor for objects of class Point
     */
    public Point()
    {
        for(int i = 0;i<100;i++)
        {
            int n = rando.nextInt(1000);
            Xcoordinates.add(n);
            n = rando.nextInt(1000);
            Ycoordinates.add(n);
        }
    }
    public abstract class CompareY implements Comparator<Point>
    {
        public CompareY()
        {
            int min = 0;
            for(int i = 0;i<100;i++)
            {
                
            }
        }
        
    }
    public abstract class CompareX implements Comparator<Point>
    {
        
    }
}
