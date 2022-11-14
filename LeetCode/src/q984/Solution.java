package q984;

class Solution {
    public String strWithout3a3b(int a, int b) {
        int countA = a;
        int countB = b;

        char A = 'a';
        char B = 'b';

        StringBuilder sb = new StringBuilder();

        if (b > a) {
            countA = b;
            countB = a;
            A = 'b';
            B = 'a';
        }

        while (countA > 0) {
            countA--;
            sb.append(A);
            if (countA > countB) {
                sb.append(A);
                countA--;
            }
            if (countB > 0) {
                sb.append(B);
                countB--;
            }
        }
        return sb.toString();
    }
}