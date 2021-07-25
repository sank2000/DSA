package Stack;

public class Main {
  public static void main(String[] args) {
    // StringReverser sr = new StringReverser();
    // BalancedExpression be = new BalancedExpression();
    
    // Stack stack = new Stack();

    // stack.push(1);
    // stack.push(2);
    // stack.push(3);
    // stack.push(4);
    // stack.push(5);

    // System.out.println(stack);

    // stack.pop();

    // System.out.println(stack.peek());
    // System.out.println(stack.isEmpty());

    DoubleStack stack = new DoubleStack();

    stack.push1(1);  
    stack.push1(2);
    
    stack.push2(3); 
    stack.push2(4); 
    stack.push2(5); 

    // stack.pop2();

    System.out.println(stack);
    

    System.out.println(stack.isFull1());
    System.out.println(stack.isFull2());
  }
}
