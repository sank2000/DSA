package Sorting;

import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean isSorted = true;
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j - 1] > arr[j]) {
          int temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;

          isSorted = false;
        }
      }
      if (isSorted)
        return;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

}