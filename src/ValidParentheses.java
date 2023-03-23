import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = Stream.of(new Character[][] {
                {')', '('},
                {'}', '{'},
                {']', '['}
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        Stack<Character> leftBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // if current character is a left bracket
            if (brackets.containsValue(s.charAt(i))) {
                leftBrackets.push(s.charAt(i));
            }
            // if current character is a right bracket
            if (brackets.containsKey(s.charAt(i))) {
                if (leftBrackets.empty()) {
                    // if you have a right bracket before you have any left brackets, this is not valid
                    return false;
                } else {
                    char leftBracket = leftBrackets.pop();
                    if (brackets.get(s.charAt(i)) != leftBracket) {
                        /* if the left bracket popped from the left brackets stack is not the one we should expect for
                         * the current right bracket
                         */
                        return false;
                    }
                }
            }
        }
        // last check is to make sure that leftBrackets is empty, meaning that all brackets have been closed
        return leftBrackets.empty();
    }
}
public class ValidParentheses {
    public static void main(String[] args) {
        Solution soln = new Solution();
        boolean solution1 = soln.isValid("()");
        boolean solution2 = soln.isValid("()[]{}");
        boolean solution3 = soln.isValid("(]");
        System.out.println("Solution 1 is " + solution1);
        System.out.println("Solution 2 is " + solution2);
        System.out.println("Solution 3 is " + solution3);
    }
}
