import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If pattern length and number of words don't match, it's impossible
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            
            // Check pattern -> word mapping
            if (map.containsKey(c)) {
                if (!map.get(c).equals(w)) return false; // mismatch
            } else {
                map.put(c, w);
            }
            
            // Check word -> pattern mapping
            if (reverseMap.containsKey(w)) {
                if (reverseMap.get(w) != c) return false;
            } else {
                reverseMap.put(w, c);
            }
        }
        
        return true;
    }
}
