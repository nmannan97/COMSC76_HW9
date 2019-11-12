import java.util.*;
import java.lang.Math; 
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Sorting
{
    //array sizes: 50,000 , 100,000 , 150,000 , 200,000 , 250,000 , 300,000.
    public Sorting(){}

    public static int[] insertionSort(int[] list)
    {
        int[] Return = new int[list.length];
        int min = list[0];
        int temp = 0;
        for(int i = 0;i<list.length;i++)
        {
            min = list[i];
            for(int j = i;j<list.length;j++)
            {
                if(list[j]<min)
                {
                    temp = min;
                    min = list[j];
                    list[j] = temp;
                } 
            }
            Return[i] = min;
        }
        return Return;
    }

    public static int[] mergeSort(int[] list)
    {
        int[] Return = new int[32];
        Return = list;
        ArrayList arr = new ArrayList();
        int temp = 0;
        int count = 0;
        int length = list.length;
        int min = 0;
        int start = 0;
        int end = 0;
        while(length>0){
            count+= 1;
            length = length/2;
        }
        for(int i = 0;i<count;i++)
        {
            min = list[i];
            end = (int)Math.pow(2,i);
            for(int k = 0;k<end && k<list.length;k++)
            {
                if(list[k]<min)
                {
                    temp = min;
                    min = list[k];
                    list[k] = temp;
                } 
                Return[k] = min;
                
            }
            end = 0;
        }
        return Return;
    }
    public static void quickSort(int[] list, int first, int last)
    {
        
    }
    public static void main(String[] args)
    {
        Random rando = new Random();
        int[] var = new int[20];
        for(int i = 0;i<var.length;i++)
        {
            var[i] = rando.nextInt(100);
            System.out.println(var[i]);
        }
        Sorting sort = new Sorting();
        var = sort.mergeSort(var);
        System.out.println("organized list");
        for(int i = 0;i<var.length;i++)
        {
            System.out.println(var[i]);
        }
    }
}
