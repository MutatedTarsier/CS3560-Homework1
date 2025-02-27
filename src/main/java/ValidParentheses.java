/************************
    Method: Use a stack to find if the last pushed element is an open parentheses/bracket
            of matching type
 *************************/

import java.util.Stack;
public class ValidParentheses {
    public boolean check(String parentheses){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '('){
                stack.push(')');
            } else if (c == '['){
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c){
                // Stack may be empty if the latest action was a pop and there are no elements left
                // Latest element is popped only if nothing is pushed, which means the pop is not run everytime
                return false;
            }

        }
        return stack.empty();
    }
}
