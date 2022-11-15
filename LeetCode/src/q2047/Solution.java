package q2047;

public class Solution {
    public int countValidWords(String sentence) {
        int count = 0;
        String[] words = sentence.trim().split("\\s+");

        for (String word : words) {
            boolean passed = true;
            int countHyphen = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    passed = false;
                    break;
                }
                if (i == 0 && c == '-') {
                    passed = false;
                    break;
                }
                if (i == word.length() - 1) {
                    if (c == '-') {
                        passed = false;
                        break;
                    }
                } else {
                    if (c == '!' || c == '.' || c == ',') {
                        passed = false;
                        break;
                    }
                    if (c == '-') {
                        if (countHyphen > 0 || word.charAt(i + 1) - 'a' < 0 || word.charAt(i + 1) - 'a' > 25) {
                            passed = false;
                            break;
                        }
                        countHyphen++;
                    }
                }
            }
            if (passed)
                count++;
        }
        return count;
    }
}