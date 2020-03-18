import java.util.*;
class RandomMerge {
  public static void fill(int array[]) 
 {
    Random t = new Random();

    for (int i =0;i<array.length;i++)
            array[i] = t.nextInt();
    }
  public static void display(int arr[])  {
        System.out.println("The array elements are : ");
        for (int i =0;i<arr.length;i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }

  public static void merge(int data[],int small,int med, int large) {
        int first = med;
        int second = med + 1;
        int l = small;
        while ((l<=first) && (second <= large))  {
            if (data[small] < data[second])
                small++;
            else {
                int temp = data[second];
                for (int j = second - 1; j>= small; j--)
                    data[j+1] = data[j];
                data[small] = temp;
                small++;
                first++;
                second++;
            }
        }
    }

  public static void mergeSort(int data[],int small,int large)   {
        // base case
        if (small >= large)
            return;
        int med = (small+large)/2;
        // divide list
        mergeSort(data,small,med);
        mergeSort(data,med+1,large);
        // merge and sort the divided lists
        merge(data,small,med,large);
    }
   public static void main(String[] args) {
        int [] data = new int[100];
        // fill array with random elements
        fill(data);
        // display the array
        display(data);
        // call mergesort function
        mergeSort(data,0,99);
        // display sorted array
        display(data);
    }
}