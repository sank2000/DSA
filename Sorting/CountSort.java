package Sorting;

import java.util.Arrays;

public class CountSort {
  public static void sort(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }

    int[] countArr = new int[max + 1];
    for (int itr : arr) {
      countArr[itr]++;
    }

    int ind = 0;
    for (int i = 0; i < countArr.length; i++) {
      while (countArr[i] != 0) {
        arr[ind++] = i;
        countArr[i]--;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = { 5, 3, 2, 5, 4, 4, 5 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
