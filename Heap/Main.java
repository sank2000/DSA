package Heap;

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

  }

}
