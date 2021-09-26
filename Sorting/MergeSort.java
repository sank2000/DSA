package Sorting;

import java.util.Arrays;

public class MergeSort {
  public static int[] sort(int[] arr) {

    if (arr.length != 1) {
      int split = arr.length / 2;

      int[] left = sort(Arrays.copyOfRange(arr, 0, split));
      int[] right = sort(Arrays.copyOfRange(arr, split, arr.length));

      int i = 0, j = 0, k = 0;

      while (i < left.length || j < right.length) {

        if (i == left.length) {
          arr[k++] = right[j++];
          continue;
        }

        if (j == right.length) {
          arr[k++] = left[i++];
          continue;
        }

        if (left[i] < right[j]) {
          arr[k++] = left[i++];
        } else {
          arr[k++] = right[j++];
        }
      }

    }

    return arr;
  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    System.out.println(Arrays.toString(sort(arr)));
  }
}
