package Heap;

public class FindKthLargestValue {
  public static int find(int[] arr, int k) {

    if (k == 0 || k > arr.length)
      throw new IllegalStateException();

    Heap hp = new Heap();

    for (int i = 0; i < arr.length; i++) {
      hp.insert(arr[i]);
    }

    for (int i = 1; i < k; i++) {
      hp.remove();
    }

    return hp.getMax();
  }
}
