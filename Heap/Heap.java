package Heap;

import java.util.Arrays;

public class Heap {

  private int[] arr;
  private int SIZE;
  private int count = 0;

  public Heap() {
    SIZE = 5;
    arr = new int[SIZE];
  }

  public Heap(int size) {
    SIZE = size;
    arr = new int[SIZE];
  }

  public void insert(int value) {
    if (count == SIZE)
      throw new IllegalStateException();

    arr[count] = value;

    int parent = findParentIndex(count);
    int index = count;
    while (parent >= 0 && arr[parent] < arr[index]) {
      swap(parent, index);
      index = parent;
      parent = findParentIndex(parent);
    }

    count++;
  }

  public int remove() {
    if (count == 0)
      throw new IllegalStateException();

    var value = arr[0];
    arr[0] = arr[--count];

    bubbleDown();

    return value;
  }

  private void bubbleDown() {
    var index = 0;
    while (index <= count && !isValidParent(index)) {
      var largerChildIndex = largerChildIndex(index);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }

  public boolean isEmpty() {
    return count == 0;
  }

  private int largerChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= count;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= count;
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    var isValid = arr[index] >= leftChild(index);

    if (hasRightChild(index))
      isValid &= arr[index] >= rightChild(index);

    return isValid;
  }

  private void swap(int parent, int index) {
    int temp = arr[index];
    arr[index] = arr[parent];
    arr[parent] = temp;
  }

  private int findParentIndex(int child) {
    return (child - 1) / 2;
  }

  private int leftChild(int parent) {
    return arr[leftChildIndex(parent)];
  }

  private int rightChild(int parent) {
    return arr[rightChildIndex(parent)];
  }

  private int leftChildIndex(int parent) {
    return (parent * 2) + 1;
  }

  private int rightChildIndex(int parent) {
    return (parent * 2) + 2;
  }

  @Override
  public String toString() {
    var content = Arrays.copyOfRange(arr, 0, count);
    return Arrays.toString(content);
  }

  public int getMax() {
    if (count == 0)
      throw new IllegalStateException();

    return arr[0];
  }

  public boolean isMaxHeap() {
    boolean maxHeap = true;

    for (int i = 0; i < arr.length; i++) {
      if ((hasLeftChild(i) && leftChild(i) > arr[i]) || (hasRightChild(i) && rightChild(i) > arr[i])) {
        maxHeap = false;
        break;
      }
    }

    return maxHeap;
  }

}
