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

    public static void quickSort(int[] list) {   
        quickSort(list, 0, list.length - 1);  
    }  

    private static void quickSort(int[] list, int first, int last) 
    {    
        if (last > first) { 
            int pivotIndex = partition(list, first, last); 
            quickSort(list, first, pivotIndex - 1);    
            quickSort(list, pivotIndex + 1, last); 
        }  
    }

    private static int partition(int[] list, int first, int last) 
    { 
        int pivot = list[first]; // Choose the first element as the pivot 
        int low = first + 1; // Index for forward search    
        int high = last; // Index for backward search    
        while (high > low) {      // Search forward from left      
            while (low <= high && list[low] <= pivot)        
                low++;      // Search backward from right 
            while (low <= high && list[high] > pivot)  
                high--;      // Swap two elements in the list   
            if (high > low) {        
                int temp = list[high];  
                list[high] = list[low];   
                list[low] = temp;      }  
        }   
        while (high > first && list[high] >= pivot) 
            high--;    // Swap pivot with list[high] 
        if (pivot > list[high]) {   
            list[first] = list[high]; 
            list[high] = pivot;     
            return high;   
        }   
        else { 
            return first; 
        }  
    }  

    /** Heap sort method */  
    public static <E extends Comparable> void heapSort(E[] list) 
    {    // Create a Heap of integers   
        Heap<E> heap = new Heap<E>();    // Add elements to the heap    
        for (int i = 0; i < list.length; i++)      
            heap.add(list[i]);    // Remove elements from the heap  
        for (int i = list.length - 1; i >= 0; i--)      
            list[i] = heap.remove();  
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
        sort.quickSort(var);
        System.out.println("organized list");
        for(int i = 0;i<var.length;i++)
        {
            System.out.println(var[i]);
        }
    }
}
