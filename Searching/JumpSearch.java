package Searching;

public class JumpSearch {

  public static int search(int[] arr, int key) {

    int start = 0;
    int blockSize = (int) Math.sqrt(arr.length);
    int end = blockSize + 1;

    while (start < arr.length) {
      if (arr[end - 1] >= key) {
        for (int index = start; index < end; index++) {
          if (arr[index] == key) {
            return index;
          }
        }
        return -1;
      }
      start += blockSize;
      end += blockSize;

      if (end > arr.length - 1)
        end = arr.length;
    }

    return -1;

  }

  public static void main(String[] args) {
    int[] arr = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };
    System.out.println(search(arr, 12));
  }

}
