package Heap;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    Heap hp = new Heap();

    hp.insert(10);
    hp.insert(5);
    hp.insert(17);
    hp.insert(4);
    hp.insert(22);

    System.out.println(hp);

    hp.remove();

    System.out.println(hp);

    int arr[] = { 5, 3, 8, 4, 1, 2 };
    Heapify.heapify(arr);

    System.out.println(Arrays.toString(arr));

  }

}
