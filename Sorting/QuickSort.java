package Sorting;

import java.util.Arrays;

public class QuickSort {

  public static void sort(int[] arr, int start, int end) {
    int b = start - 1;
    int pivotIndex = end - 1;
    for (int i = start; i < end; i++) {
      if (arr[i] <= arr[pivotIndex]) {
        int temp = arr[i];
        arr[i] = arr[++b];
        arr[b] = temp;
      }
    }
    if (start - b != 0)
      sort(arr, start, b);
    if (end - (b + 1) != 0)
      sort(arr, b + 1, end);

  }

  public static void main(String[] args) {
    int[] arr = { 15, 6, 3, 1, 22, 10, 13 };
    sort(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));
  }

}
