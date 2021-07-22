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
      reAllocate();
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

  public void reversPrint() {
    int[] arrRev = new int[SIZE];
    int index = 0;
    for (int ind = length - 1; ind >= 0; ind--) {
      arrRev[index++] = arr[ind];
    }

    for (int ind = 0; ind < length; ind++) {
      System.out.print(arrRev[ind]);
    }
    System.out.println();
  }
  
  public int getMax() {
    int max = arr[0];
    for (int i = 1; i < length; i++) {
      if (arr[i] > max)
        max = arr[i];
    }
    return max;
  }

  public void insertAt(int item, int index) {
    if (length >= SIZE) {
      reAllocate();
    }
    for (int ind = length-1; ind >= index; ind--) 
      arr[ind + 1] = arr[ind];
    arr[index] = item;
  }
  
  private void reAllocate() {
    SIZE *= 2;
    int[] newArr = new int[SIZE];
    for (int i = 0; i < length; i++) {
      newArr[i] = arr[i];
    }
    arr = newArr;
  }

  public int[] getFullArray() {
    return arr;
  }

  public int getLength() {
    return length;
  }

  public Array intersect(Array anotherArray) {

    int maxLength = 0;
    if(length > anotherArray.getLength()){
      maxLength = length;
    } else {
      maxLength = anotherArray.getLength();
    }

    Array arrInter = new Array(maxLength);

    for (int outer : anotherArray.getFullArray()) {
      for (int inner : arr) {
        if (outer == inner) {
          if(arrInter.indexOf(outer) == -1)
            arrInter.insert(outer);
        }
      }
    }
    
    return arrInter;
  }

}
