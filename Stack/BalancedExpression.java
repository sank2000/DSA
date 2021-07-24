package Stack;
import java.util.Stack;

public class BalancedExpression {

  public boolean check(String str) {

    Stack<Character> stack = new Stack<Character>();

    for (char ch : str.toCharArray()) {
      if (ch == '(' || ch == '<' || ch == '[' || ch == '{')
        stack.push(ch);
      else if (ch == ')' || ch == '>' || ch == ']' || ch == '}') {

        if (stack.isEmpty() || !checkPair(stack.peek(), ch))
          return false;

        stack.pop();
      }
    }

    return stack.isEmpty();

  }
  
  private boolean checkPair(Character open,Character close) {
    return ((open == '(' && close == ')') || (open == '<' && close == '>') || (open == '{' && close == '}') || (open == '[' && close == ']'));
  }
  
}
