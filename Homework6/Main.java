import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    // instance variables - replace the example below with your own
    private static Point[] p = new Point[100];
    public static void main(String[] args)
    {
        for(int i = 0;i<100;i++){
            p[i] = new Point();
            System.out.println("" + p[i].getX() + "," +p[i].getY());
        }
        CompareX(new PointSort());
    }
    public static void CompareX(Comparator<Point> c)
    {
        int count = 1;
        for(int i = 1;i<100;i++)
        {
            count = i;
            //if(c.compare(p[i],p[i-1]) == 0)    
            while(c.compare(p[count],p[count-1])<0)
            {
                Point temp = p[count-1];
                p[count-1] = p[count];
                p[count] = temp;
                count--;
                if(count == 0) break;
            }
            System.out.println("" + p[i].getX() + "," +p[i].getY());
        }
    }
}
