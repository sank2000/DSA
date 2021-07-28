package HashTable;

import java.util.HashMap;
import java.util.Map;

public class NonRepeating {
  public Character findFirstCharacter(String str) {
    
    Map<Character, Integer> map = new HashMap<>();
    var characters = str.toCharArray();
    
    for (Character item : characters) {
      if (map.containsKey(item)) {
        map.put(item, map.get(item) + 1);
      } else {
        map.put(item, 1);
      }
    }

    for (var item : characters) {
      if(map.get(item) == 1)
        return item;
    }

    return null;
  }
}
