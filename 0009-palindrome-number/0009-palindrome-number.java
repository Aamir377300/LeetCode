class Solution {
    public boolean isPalindrome(int x) {
        // negative number cannot be palindrome
        if(x<0) return false;

        int reverse=0;
        int original=x;

        while (x > 0) {
            int digit = x % 10;           // Get last digit
            reverse = reverse * 10 + digit; // Add digit to reversed number
            x = x / 10;                   // Remove last digit
        }

        return original == reverse;
    }
}