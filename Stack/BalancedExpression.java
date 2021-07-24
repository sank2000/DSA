package Stack;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

  private final List<Character> leftBrackets = Arrays.asList('(','[','{','<');
  private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

  public boolean check(String str) {
    Stack<Character> stack = new Stack<Character>();

    for (char ch : str.toCharArray()) {
      if (isLeftBracket(ch))
        stack.push(ch);
      else if (isRightBracket(ch)) {
        if (stack.isEmpty() || !checkPair(stack.peek(), ch))
          return false;

        stack.pop();
      }
    }

    return stack.isEmpty();
  }
  
  private boolean checkPair(Character open, Character close) {
    return leftBrackets.indexOf(open) == rightBrackets.indexOf(close);
  }
  
  private boolean isLeftBracket(Character ch) {
    return leftBrackets.contains(ch);
  }

  private boolean isRightBracket(Character ch) {
    return rightBrackets.contains(ch);
  }
}
