package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Repeating {
  public static Character findFirst(String str) {
    Set<Character> set = new HashSet<>();

    for (Character item : str.toCharArray()) {
      if (set.contains(item)) {
        return item;
      } else {
        set.add(item);
      }
    }

    return Character.MAX_VALUE;
  }
}
