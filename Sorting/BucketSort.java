package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

  public static void sort(int[] arr) {
    ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
    int noOfBuckets = 3;

    for (int i = 0; i < noOfBuckets; i++) {
      buckets.add(new ArrayList<Integer>());
    }

    for (int itr : arr) {
      buckets.get(itr / noOfBuckets).add(itr);
    }

    int k = 0;
    for (ArrayList<Integer> bucket : buckets) {
      Collections.sort(bucket);
      for (int val : bucket) {
        arr[k++] = val;
      }
    }

  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
