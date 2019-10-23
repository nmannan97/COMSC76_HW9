import java.util.Comparator;
/**
 * Write a description of class PointSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PointSort implements Comparator<Point>
{
    public int compare(Point p1, Point p2)
    {
        double p1x = p1.getX();
        double p2x = p2.getX();
        if(p1x>p2x) return 1;
        else if(p1x == p2x) return 0;
        else return -1;
    }
}
