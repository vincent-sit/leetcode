package q1961;

public class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int l = 0;
        int r = 0;
        int i = 0;

        while (r < s.length() && i < words.length) {
            String word = words[i];
            r += word.length();

            if (word.equals(s.substring(l, r))) {
                l = r;
            } else
                return false;
        }
        return true;
    }
}