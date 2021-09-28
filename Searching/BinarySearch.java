package Searching;

public class BinarySearch {

  public static int searchRecursive(int[] arr, int key, int left, int right) {

    int middle = (left + right) / 2;

    if (left > right)
      return -1;

    if (arr[middle] < key) {
      return searchRecursive(arr, key, middle + 1, right);
    } else if (arr[middle] > key) {
      return searchRecursive(arr, key, left, middle - 1);
    }

    return middle;

  }

  public static int searchIterative(int[] arr, int key) {

    int left = 0;
    int right = arr.length - 1;
    int middle;

    while (left <= right) {
      middle = (left + right) / 2;
      if (arr[middle] == key)
        return middle;
      if (arr[middle] < key) {
        left = middle + 1;
      } else if (arr[middle] > key) {
        right = middle - 1;
      }
    }

    return -1;

  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
    System.out.println(searchRecursive(arr, 2, 0, arr.length - 1));
    System.out.println(searchIterative(arr, 2));
  }

}
