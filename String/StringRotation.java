package String;

/**
 * StringRotation
 */

public class StringRotation {
  public static void main(String[] args) {
    String str1 = "ABCD";
    String str2 = "CDAB";

    int i = str2.indexOf(str1.charAt(0));

    for (int index = 0; index < str1.length(); index++) {
      if (str1.charAt(index) == str2.charAt(i)) {
        i = (i + 1) % str1.length();
      } else {
        System.out.println(false);
        return;
      }
    }

    System.out.println(true);

  }

}
