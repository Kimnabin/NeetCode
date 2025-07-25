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