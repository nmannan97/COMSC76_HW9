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

    public static void mergeSort(int[] list) {    
        if (list.length > 1) {      // Merge sort the first half  
            int[] firstHalf = new int[list.length / 2];    
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);      // Merge sort the second half     
            int secondHalfLength = list.length - list.length / 2;     
            int[] secondHalf = new int[secondHalfLength];      
            System.arraycopy(list, list.length / 2,        secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);      // Merge firstHalf with secondHalf into list 
            merge(firstHalf, secondHalf, list);    }  
    }  

    /** Merge two sorted lists */ 
    public static void merge(int[] list1, int[] list2, int[] temp) {   
        int current1 = 0; // Current index in list1   
        int current2 = 0; // Current index in list2  
        int current3 = 0; // Current index in temp    
        while (current1 < list1.length && current2 < list2.length) { 
            if (list1[current1] < list2[current2])       
                temp[current3++] = list1[current1++];      
            else        temp[current3++] = list2[current2++];    }   
        while (current1 < list1.length)      
            temp[current3++] = list1[current1++];  
        while (current2 < list2.length)      
            temp[current3++] = list2[current2++];  
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
    public static  int[] heapSort(int []list) 
    {    //Heap parent at i, left is 2i+1 , right is 2i+2  
        int [] Return = new int[list.length+1];
        for(int i = 0; i<list.length/2;i+=3)
        {
            Return[i] = list[i];
            Return[i+1] = list[2*i+1];
            if(i<list.length/2-2)
                Return[i+2] = list[2*i+2];
        }
        for(int i = 0;i<list.length;i++)
        {
            System.out.println(Return[i]);
        }
        return Return;
    } 

    public static <E extends Comparable> void heapSort(E[] list) {    // Create a Heap of integers    
        Heap<E> heap = new Heap<E>();    // Add elements to the heap   
        for (int i = 0; i < list.length; i++)     
            heap.add(list[i]);    // Remove elements from the heap 
        for (int i = list.length - 1; i >= 0; i--)     
            list[i] = heap.remove();  
    } 

    public static void main(String[] args){
        Random rando = new Random();
        int[] var = new int[20];
        for(int i = 0;i<var.length;i++)
        {
            var[i] = rando.nextInt(100);
            System.out.println(var[i]);
        }
        Sorting sort = new Sorting();
        sort.heapSort(var);
        System.out.println("organized list");
        for(int i = 0;i<var.length;i++)
        {
            System.out.println(var[i]);
        }
    }
}
class Heap<E extends Comparable> {  
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();  
    public Heap() {}  

    /** Create a heap from an array of objects */ 
    public Heap(E[] objects) {   
        for (int i = 0; i < objects.length; i++)      
            add(objects[i]);  
    }  

    /** Add a new object into the heap */ 
    public void add(E newObject) {    
        list.add(newObject); // Append to the heap    
        int currentIndex = list.size() - 1; // The index of the last node   
        while (currentIndex > 0) {      
            int parentIndex = (currentIndex - 1) / 2;      // Swap if the current object is greater than its parent   
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) 
            {        E temp = list.get(currentIndex);       
                list.set(currentIndex, list.get(parentIndex));      
                list.set(parentIndex, temp);      }     
            else        
                break; // the tree is a heap now     
            currentIndex = parentIndex;    }  }  

    /** Remove the root from the heap */ 
    public E remove() {   
        if (list.size() == 0) return null;    
        E removedObject = list.get(0);    
        list.set(0, list.get(list.size() - 1));   
        list.remove(list.size() - 1);  
        int currentIndex = 0;    
        while (currentIndex < list.size()) {    
            int leftChildIndex = 2 * currentIndex + 1;  
            int rightChildIndex = 2 * currentIndex + 2;      // Find the maximum between two children 
            if (leftChildIndex >= list.size()) break; // The tree is a heap  
            int maxIndex = leftChildIndex;     
            if (rightChildIndex < list.size()) {        
                if (list.get(maxIndex).compareTo(           
                    list.get(rightChildIndex)) < 0) {          
                    maxIndex = rightChildIndex;        }   
            }
            // Swap if the current node is less than the maximum   
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {    
                E temp = list.get(maxIndex);       
                list.set(maxIndex, list.get(currentIndex));  
                list.set(currentIndex, temp);       
                currentIndex = maxIndex;      }     
            else        
                break; // The tree is a heap  
        }    return removedObject;  }  

    /** Get the number of nodes in the tree */ 
    public int getSize() {    
        return list.size();
    }
}
