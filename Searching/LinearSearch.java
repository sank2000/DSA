package Searching;

/**
 * LinearSearch
 */
public class LinearSearch {

  public static int search(int[] arr, int key) {
    int found = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == key) {
        found = i;
        break;
      }
    }
    return found;
  }

  public static void main(String[] args) {
    int[] arr = { 8, 2, 4, 1, 3 };
    System.out.println(search(arr, 5));
  }

}