package Array;

import java.util.Arrays;

class Array {
  
  private int[] arr;
  private int SIZE = 5;

  private int length = 0;

  Array(int size) {
    arr = new int[size];
    SIZE = size;
  }

  Array() {
    arr = new int[SIZE];
  }

  public void insert(int value) {
    if (length >= SIZE) {
      SIZE *= 2;
      int[] newArr = new int[SIZE];
      for (int i = 0; i < length; i++) {
        newArr[i] = arr[i];
      }
      arr = newArr;
    }
    arr[length] = value;
    length++;
  }

  public String getArrayString() {
    return Arrays.toString(arr);
  }

  public int indexOf(int item) {
    for (int ind = 0; ind < length; ind++) {
      if (item == arr[ind]) {
        return ind;
      }
    }
    return -1;
  }

  public boolean removeAt(int index) {
    if (index > length - 1)
      return false;
    for (int ind = index + 1; ind <= length; ind++) {
      arr[ind - 1] = arr[ind];
    }
    length--;
    return true;
  }
  
}
