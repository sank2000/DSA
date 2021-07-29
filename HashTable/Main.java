package HashTable;

public class Main {
  public static void main(String[] args) {
    // NonRepeating nr = new NonRepeating();
    // System.out.println(nr.findFirstCharacter("a green apple"));
    // System.out.println(Repeating.findFirst("a green apple"));

    HashTableUsingLL htl = new HashTableUsingLL();
    htl.put(1, "san");
    htl.put(2, "san");
    htl.put(2, "test");
    htl.print();
    System.out.println(htl.get(2));
    htl.remove(1);
    htl.print();
  }
}
