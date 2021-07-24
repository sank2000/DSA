package Stack;

import java.util.Stack;

public class StringReverser {

  public String reverse(String str) {
    if(str == null) 
      throw new IllegalArgumentException();

    Stack<Character> stack = new Stack<Character>();
    
    for (char ch : str.toCharArray()) {
      stack.push(ch);
    }

    String revStr = "";
    // for optimization we can use buffer class

    while (!stack.isEmpty()) {
      revStr += stack.pop();
    }

    return revStr;
  }
  
}
