package String;

public class Capitalize {

  public static void main(String[] args) {
    String str = " trEes   are  beautiful   ".trim();

    StringBuilder output = new StringBuilder();

    if (str == "" || str == null)
      return;

    if (Character.isLowerCase(str.charAt(0))) {
      output.append(Character.toUpperCase(str.charAt(0)));
    }

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        while (str.charAt(i) == ' ') {
          i++;
        }
        output.append(" " + Character.toUpperCase(str.charAt(i)));
      } else {
        output.append(Character.toLowerCase(str.charAt(i)));
      }
    }

    System.out.println(output.toString());

  }

}
