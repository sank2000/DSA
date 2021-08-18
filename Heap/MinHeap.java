package Heap;

public class MinHeap {

  private class Node {
    private int key;
    private String value;

    Node(int k, String str) {
      key = k;
      value = str;
    }

    @Override
    public String toString() {
      return key + " --- " + value;
    }
  }

  private Node[] arr = new Node[10];
  private int SIZE = 0;

  public void insert(int k, String str) {
    if (isFull())
      throw new IllegalStateException();

    arr[SIZE] = new Node(k, str);

    bubbleUp();

    SIZE++;
  }

  private void bubbleUp() {
    int index = SIZE;
    int parentIndex = findParentIndex(SIZE);

    while (parentIndex >= 0 && arr[index].key < arr[parentIndex].key) {
      swap(parentIndex, index);
      index = parentIndex;
      parentIndex = findParentIndex(parentIndex);
    }

  }

  public String remove() {
    if (isEmpty())
      throw new IllegalStateException();

    Node temp = arr[0];
    arr[0] = arr[--SIZE];

    bubbleDown();

    return temp.toString();
  }

  private void bubbleDown() {
    var index = 0;
    while (index <= SIZE && !isValidParent(index)) {
      var smallerChildIndex = smallerChildIndex(index);
      swap(index, smallerChildIndex);
      index = smallerChildIndex;
    }
  }

  private int findParentIndex(int child) {
    return (child - 1) / 2;
  }

  private void swap(int parent, int index) {
    Node temp = arr[index];
    arr[index] = arr[parent];
    arr[parent] = temp;
  }

  private Node leftChild(int parent) {
    return arr[leftChildIndex(parent)];
  }

  private Node rightChild(int parent) {
    return arr[rightChildIndex(parent)];
  }

  private int leftChildIndex(int parent) {
    return (parent * 2) + 1;
  }

  private int rightChildIndex(int parent) {
    return (parent * 2) + 2;
  }

  private int smallerChildIndex(int index) {
    if (!hasLeftChild(index))
      return index;

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return (leftChild(index).key < rightChild(index).key) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= SIZE;
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= SIZE;
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    var isValid = arr[index].key <= leftChild(index).key;

    if (hasRightChild(index))
      isValid &= arr[index].key <= rightChild(index).key;

    return isValid;
  }

  public boolean isFull() {
    return SIZE == arr.length;
  }

  public boolean isEmpty() {
    return SIZE == 0;
  }

}
