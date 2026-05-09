import java.util.*;
public class Pr6
{
 static int linearSearch(int a[], int key)
 {
 for(int i = 0; i < a.length; i++)
 {
 System.out.println("Pass " + (i + 1) + ": checking " + a[i]);
 if(a[i] == key)
 return i;
 }
 return -1;
 }
 static int binarySearch(int a[], int key)
 {
 int low = 0, high = a.length - 1;
 int pass = 1;
 while(low <= high)
 {
 int mid = (low + high) / 2;
 System.out.println("Pass " + pass + 
 ": low=" + low + " high=" + high + 
 " mid=" + mid + " value=" + a[mid]);
 if(a[mid] == key)
 return mid;
 else if(a[mid] < key)
 low = mid + 1;
 else
 high = mid - 1;
 pass++;
 }
 return -1;
 }
 public static void main(String args[])
 {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter number of elements:");
 int n = sc.nextInt();
 int a[] = new int[n];
 for(int i = 0; i < n; i++)
 {
 a[i] = (int)(Math.random() * 100);
 }
 System.out.println("Array:");
 for(int i = 0; i < n; i++)
 {
 System.out.print(a[i] + " ");
 }
 System.out.println("\nEnter element to search:");
 int key = sc.nextInt();
    long start1 = System.nanoTime();
 int pos1 = linearSearch(a, key);
 long end1 = System.nanoTime();
 Arrays.sort(a);
 System.out.println("\nSorted Array:");
 for(int i = 0; i < n; i++)
 {
 System.out.print(a[i] + " ");
 }
 long start2 = System.nanoTime();
 int pos2 = binarySearch(a, key);
 long end2 = System.nanoTime();
 if(pos1 != -1)
 System.out.println("\nLinear Search: Found at index " + pos1);
 else
 System.out.println("\nLinear Search: Not found");
 if(pos2 != -1)
 System.out.println("Binary Search: Found at index " + pos2);
 else
 System.out.println("Binary Search: Not found");
 System.out.println("\nLinear Search Time: " + (end1 - start1));
 System.out.println("Binary Search Time: " + (end2 - start2));
 }
}
