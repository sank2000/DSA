package String;

import java.util.HashMap;

public class Anagram {

  public static boolean check(String str1, String str2) {

    HashMap<Character, Integer> list1 = new HashMap<Character, Integer>();
    HashMap<Character, Integer> list2 = new HashMap<Character, Integer>();

    for (Character ch : str1.toCharArray()) {
      if (list1.get(ch) != null)
        list1.put(ch, list1.get(ch) + 1);
      else
        list1.put(ch, 1);
    }

    for (Character ch : str2.toCharArray()) {
      if (list2.get(ch) != null)
        list2.put(ch, list2.get(ch) + 1);
      else
        list2.put(ch, 1);
    }

    for (var entry : list1.entrySet()) {
      if (list2.get(entry.getKey()) == null || list2.get(entry.getKey()) != entry.getValue()) {
        return false;
      }
      list2.remove(entry.getKey());
    }

    if (!list2.isEmpty())
      return false;

    return true;
  }

  public static void main(String[] args) {
    System.out.println(check("abcd", "abce"));
  }

}
