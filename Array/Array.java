package Array;

import java.util.Arrays;

class Array {
  
  private int[] arr;
  private int SIZE = 5;

  private int length = 0;

  Array(int size) {
    arr = new int[size];
  }

  Array() {
    arr = new int[5];
  }

  public void insert(int value) {
    if (length >= SIZE) {
      SIZE += 5;
      int[] newArr = new int[SIZE];
      for (int i = 0; i < arr.length; i++) {
        newArr[i] = arr[i];
      }
      newArr[length] = value;
      arr = newArr;
    }
    arr[length] = value;
    length++;
  }

  public String getArrayString() {
    return Arrays.toString(arr);
  }

  public int indexOf(int item) {
    for (int ind = 0; ind < arr.length; ind++) {
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
    return true;
  }
  
}
