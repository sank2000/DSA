package Queue;

import java.util.Arrays;

public class ArrayQueue {
  int[] arr;
  int SIZE = 5;
  int front = 0;
  int rear = 0;

  ArrayQueue(int size) {
    SIZE = size;
    arr = new int[SIZE];
  }
  
  ArrayQueue() {
    arr = new int[SIZE];
  }

  public void enqueue(int value) {
    if (isFull())
      throw new IllegalStateException();
    arr[rear++] = value;
  }

  public int dequeue() {
    if (isEmpty())
      throw new IllegalStateException();

    var item = arr[front];
    arr[front++] = 0;

    return item;
  }

  public int peek() {
    if (isEmpty())
      throw new IllegalStateException();
    return arr[front - 1];
  }

  public boolean isEmpty() {
    return front == rear;
  }

  public boolean isFull() {
    return rear == SIZE;
  }

  @Override
  public String toString() {
    var content = Arrays.copyOfRange(arr, front, rear);
    return Arrays.toString(content);
  }
}
