class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;

        // Iterate over all possible characters 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            // Only valid if the character appears at least twice
            if (first != -1 && last != -1 && first < last) {
                // Collect distinct middle characters
                Set<Character> middleChars = new HashSet<>();
                for (int i = first + 1; i < last; i++) {
                    middleChars.add(s.charAt(i));
                }
                result += middleChars.size();
            }
        }
        return result;
    }
}