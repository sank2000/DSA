package Searching;

public class ExponentialSearch {

  public static int search(int[] arr, int key) {

    int bound = 2;
    while (bound < arr.length && arr[bound - 1] < key) {
      bound *= 2;
    }

    return BinarySearch.searchRecursive(arr, key, bound / 2, Math.min(bound, arr.length - 1));

  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
    System.out.println(search(arr, 11));
  }

}
