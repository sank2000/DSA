package String;

import java.util.HashMap;

public class RepeatedCharacter {
  public static void main(String[] args) {
    String str = "Hellooo!!";

    HashMap<Character, Integer> list = new HashMap<Character, Integer>();

    for (Character ch : str.toCharArray()) {
      if (list.get(ch) != null)
        list.put(ch, list.get(ch) + 1);
      else
        list.put(ch, 1);
    }

    int maxCount = 0;
    Character maxCh = ' ';

    for (var entry : list.entrySet()) {
      if (maxCount < entry.getValue()) {
        maxCh = entry.getKey();
        maxCount = entry.getValue();
      }
    }

    System.out.println(maxCh);
  }
}
