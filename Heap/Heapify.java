package Heap;

public class Heapify {
  public static void heapify(int[] arr) {
    int lastParentIndex = arr.length / 2 - 1;
    for (int i = lastParentIndex; i >= 0; i--) {
      heapify(arr, i);
    }
  }

  private static void heapify(int[] arr, int index) {
    int largerIndex = index;

    int left = (index * 2) + 1;
    if (left < arr.length && arr[largerIndex] < arr[left]) {
      largerIndex = left;
    }

    int right = (index * 2) + 2;
    if (right < arr.length && arr[largerIndex] < arr[right]) {
      largerIndex = right;
    }

    if (index == largerIndex)
      return;

    swap(arr, largerIndex, index);
    heapify(arr, largerIndex);
  }

  private static void swap(int[] arr, int parent, int index) {
    int temp = arr[index];
    arr[index] = arr[parent];
    arr[parent] = temp;
  }
}
