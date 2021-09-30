package String;

public class Palindrome {

  public static void main(String[] args) {
    String str = "madame";

    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) {
        System.out.println("No");
        return;
      }
    }

    System.out.println("Yes");

  }

}
