package Tries;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    Tries tr = new Tries();

    tr.insert("boy");
    tr.insert("book");
    tr.insert("border");

    System.out.println(tr.contains("border"));

    tr.traverse();

  }
}