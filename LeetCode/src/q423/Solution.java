package q423;

public class Solution {
    public String originalDigits(String s) {

        StringBuilder sb = new StringBuilder();

        // 22 is limited due to the question specifying that the smallest character is 'e'
        int[] digits = new int[22];
        int[] res = new int[10];

        for (char c : s.toCharArray()) {
            digits[c - 101]++;
        }

        // identify the unique characters - every appearance would indicate that there is one of these numbers
        res[0] = digits[21];
        res[2] = digits[18];
        res[6] = digits[19];
        res[4] = digits[16];
        res[8] = digits[2];
        // substraction is to remove duplication in letters with other numbers already counted
        res[1] = digits[10] - res[2] - res[0] - res[4];
        res[5] = digits[1] - res[4];
        res[7] = digits[14] - res[6];
        res[9] = digits[4] - res[6] - res[5] - res[8];
        res[3] = digits[13] - res[4] - res[0];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                sb.append((char) (i + 48));
            }
        }

        return sb.toString();
    }
}