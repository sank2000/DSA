package String;

import java.util.Arrays;
import java.util.Collections;

public class StatementReverse {

  public static void main(String[] args) {
    String str = "Trees are beautiful";

    String[] arr = str.split(" ");
    Collections.reverse(Arrays.asList(arr));

    System.out.println(String.join(" ", arr));
  }

}
