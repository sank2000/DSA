package Queue;

import java.util.Arrays;

public class PriorityQueue {
  private int[] arr;
  private int SIZE = 5;

  private int length;

  PriorityQueue(int size) {
    arr = new int[size];
    SIZE = size;
  }

  PriorityQueue() {
    arr = new int[SIZE];
  }

  public void insert(int value) {
    if (isFull()) {
      throw new IllegalStateException();
    }

    var i = shiftItemsToInsert(value);
    arr[i] = value;
    length++;
  }
  
  public int remove() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    int value = arr[0];
    for (int ind = 1; ind < length; ind++) {
      arr[ind - 1] = arr[ind];
    }
    length--;
    return value;
  }
  
  public boolean isFull() {
    return length == SIZE;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  private int shiftItemsToInsert(int item) {
    int i;

    for (i = length - 1; i >= 0; i--) {
      if (arr[i] > item) {
        arr[i + 1] = arr[i];
      } else {
        break;
      }
    }
    return i + 1;
  }
  
  @Override
  public String toString() {
    var content = Arrays.copyOfRange(arr, 0, length);
    return Arrays.toString(content);
  }
}
