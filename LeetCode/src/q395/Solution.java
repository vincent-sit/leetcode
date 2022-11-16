package q395;

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k)
            return 0;
        int[] res = createFreqMap(s);

        if (checkOccurrence(res, k))
            return s.length();

        int result = 0, start = 0, i = 0;

        while (i < s.length()) {
            // if we come across a char that appeared less than k times, we will check the
            // string up to it
            // then we move the start to the char after it to start looking for the longest
            // string again
            if (res[s.charAt(i) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
            i++;
        }

        // longestSubstring here would be called to see if the rest of the string
        // (despite only having char appearing more than k times) would be longer than
        // result so far
        return Math.max(result, longestSubstring(s.substring(start), k));
    }

    public boolean checkOccurrence(int[] cs, int k) {
        for (int c : cs) {
            if (c > 0 && c < k)
                return false;
        }
        return true;
    }

    public int[] createFreqMap(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            res[c - 'a']++;
        }
        return res;
    }
}
