// class Solution {
//     public boolean isPalindrome(String s) {

//     Stack<Character> st1 = new Stack<>(); 
//     Stack<Character> st2 = new Stack<>(); 
       
//     String cleaned = s.replaceAll("[^a-zA-Z0-0]", "");
        
//     cleaned = cleaned.toLowerCase();

//     for(int i=0; i<cleaned.length(); i++){
//         st1.push(cleaned.charAt(i));
//     }

//     for(int i=cleaned.length()-1; i>=0; i--){
//         st2.push(cleaned.charAt(i));
//     }

//     while(!st1.isEmpty() && !st2.isEmpty()){
//         char a = st1.pop();
//         char b = st2.pop();

//         if(a != b) return false;
//     }

//     return true;

//     }
// }

// we can also done using this


class Solution {
    public boolean isPalindrome(String s) {
        
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "");

        cleaned = cleaned.toLowerCase();

        int left =0;
        int right = cleaned.length()-1;

        while(left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}