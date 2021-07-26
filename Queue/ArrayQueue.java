package Queue;

import java.util.Arrays;

public class ArrayQueue {
  int[] arr;
  int SIZE = 5;
  int front = 0;
  int rear = 0;
  int COUNT = 0;

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
    arr[rear] = value;
    rear = (rear + 1) % SIZE;
    COUNT++;
  }

  public int dequeue() {
    if (isEmpty())
      throw new IllegalStateException();

    var item = arr[front];
    arr[front] = 0;
    front = (front + 1) % SIZE;
    COUNT--;

    return item;
  }

  public int peek() {
    if (isEmpty())
      throw new IllegalStateException();
    return arr[front - 1];
  }

  public boolean isEmpty() {
    return COUNT==0;
  }

  public boolean isFull() {
    return COUNT == SIZE;
  }

  @Override
  public String toString() {
    return Arrays.toString(arr);
  }
}
