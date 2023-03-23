import java.util.Stack;

class Solution2 {
    // faster runtime than adding both left and right brackets to a HashMap (method used in ValidParentheses.java
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

public class ValidParenthesesOnlyRightBrackets {
    public static void main(String[] args) {
        Solution2 soln = new Solution2();
        boolean solution1 = soln.isValid("()");
        boolean solution2 = soln.isValid("()[]{}");
        boolean solution3 = soln.isValid("(]");
        System.out.println("Solution 1 is " + solution1);
        System.out.println("Solution 2 is " + solution2);
        System.out.println("Solution 3 is " + solution3);
    }
}
