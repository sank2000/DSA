package String;

/**
 * VowelsCount
 */
public class VowelsCount {

  public static void main(String[] args) {
    String str = "hellO";
    int count = 0;
    if (str != null)
      for (Character ch : str.toLowerCase().toCharArray()) {
        if ("aeiou".indexOf(ch) != -1)
          count++;
      }

    System.out.println(count);
  }

}