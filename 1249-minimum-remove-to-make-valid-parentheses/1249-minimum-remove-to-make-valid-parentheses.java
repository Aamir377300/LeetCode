class Solution {
    public String minRemoveToMakeValid(String s) {
        int n= s.length();

        boolean[] remove = new boolean[n];
        Stack<Integer> st = new Stack<>(); // in the stack we put the index

        // case1: mark if the first ')' as invalid and add the '(' and then ')'
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(i);
            }

            else if(ch == ')'){
                if(!st.isEmpty()){
                    st.pop(); // matched with a '(' → valid pair
                }
                else{
                    remove[i] = true; // unmatched ')' → remove it
                }
            }
        }

        // PASS 2: Any '(' left in stack are unmatched → remove them
        while (!st.isEmpty()) {
            remove[st.pop()] = true;
        }

        // PASS 3: Build final valid string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}