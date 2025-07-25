// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// This solution uses HashTable to count the occurrences of each character in both strings.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Assuming only lowercase letters a-z

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
public class main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";

        System.out.println(solution.isAnagram(s1, t1)); // true
        System.out.println(solution.isAnagram(s2, t2)); // false
    }
}

// This solution uses hashmap to count the occurrences of each character in both strings.

class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            retufn false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();

        for ( int i = 0; i < s.lenth(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}

// This solution uses sorting to check if two strings are anagrams.
import java.util.Arrays;
class Solution3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}