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
                return false;
            }

        }
        return stack.empty();
    }
}
