package Sorting;

import java.util.Arrays;

public class InsertionSort {
  public static void sort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int current = arr[i];
      int j = i;
      while (j > 0 && arr[j - 1] > current) {
        arr[j] = arr[--j];
      }
      arr[j] = current;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
