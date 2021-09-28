package Searching;

public class TernarySearch {

  public static int search(int[] arr, int key, int left, int right) {

    int partitionSize = (right - left) / 3;
    int mid1 = left + partitionSize;
    int mid2 = right - partitionSize;

    if (left > right)
      return -1;

    if (arr[mid1] == key) {
      return mid1;
    }

    if (arr[mid2] == key) {
      return mid2;
    }

    if (key > arr[mid2]) {
      return search(arr, key, mid2 + 1, right);
    } else if (key > arr[mid1]) {
      return search(arr, key, mid1 + 1, mid2 - 1);
    }

    return search(arr, key, left, mid1 - 1);
  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
    System.out.println(search(arr, 18, 0, arr.length - 1));
  }

}
