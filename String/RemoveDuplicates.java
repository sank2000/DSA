package String;

import java.util.HashSet;

public class RemoveDuplicates {

  public static void main(String[] args) {
    String str = "Hellooo!!";
    HashSet<Character> list = new HashSet<Character>();
    StringBuilder output = new StringBuilder();

    for (Character ch : str.toCharArray()) {
      if (list.contains(ch))
        continue;
      list.add(ch);
      output.append(ch);
    }

    System.out.println(output.toString());
  }

}
