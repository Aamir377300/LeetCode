import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Step 1: If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Step 2: If closing bracket
            else {

                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check for matching pair
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        // Step 3: Stack must be empty for valid string
        return stack.isEmpty();
    }
}
