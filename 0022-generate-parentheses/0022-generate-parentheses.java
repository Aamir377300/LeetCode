// yaha open and close ka ek concept use hoga open means first '(' and if open> close the we add ')', due to valid Parenthesis add karna hai to pahle '(' aaye ga phir ')' aaye ga


// code is done but explanation is not done {muje code ke piche ka logic abhi bhi samaj nahi aaya hai}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String curr, int open, int close, int n) {
        // Base case
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            backtrack(result, curr + "(", open + 1, close, n);
        }

        // Add ')' only if valid
        if (close < open) {
            backtrack(result, curr + ")", open, close + 1, n);
        }
    }
}