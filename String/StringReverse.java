package String;

public class StringReverse {

  public static void main(String[] args) {
    String str = "Trees";

    StringBuilder reverse = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      reverse.append(str.charAt(i));
    }

    System.out.println(reverse.toString());
  }

}
