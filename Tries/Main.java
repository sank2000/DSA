package Tries;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    Tries tr = new Tries();

    tr.insert("car");
    tr.insert("card");
    tr.insert("care");
    tr.insert("careful");
    tr.insert("egg");

    System.out.println(tr.countWords());

    System.out.println(tr.contains("car"));
    System.out.println(tr.containsRecursive("card"));

    // tr.traverse();

    tr.remove("boy");
    System.out.println(tr.contains("boy"));

    System.out.println(tr.getSuggestion("car"));
  }
}