package q151;

import java.util.*;

public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 1)
            return s;

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int a = 0;
        int b = 0;

        while (b < s.length()) {
            // find occurrence of whitespace
            b = s.indexOf(" ", a + 1);
            
            // if no whitespace found, add the substring from a as one word
            if (b == -1) {
                res.add(s.substring(a));
                break;
            }
            String c = s.substring(a, b).trim();
            if (!c.equals("")) {
                res.add(c);
            }
            // move a to b to look for string b's position
            a = b;
        }

        if (res.size() == 1)
            return res.get(0);

        // naive way of reversing the string by adding the strings into a stringbuilder backwards
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}