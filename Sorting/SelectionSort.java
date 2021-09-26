package Sorting;

import java.util.Arrays;

public class SelectionSort {
  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[minIndex] > arr[j])
          minIndex = j;
      }
      if (minIndex != i) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
