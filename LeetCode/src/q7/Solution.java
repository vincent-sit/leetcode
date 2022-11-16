package q7;

public class Solution {
    public int reverse(int x) {
        int res = 0;
        int preRes = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            if ((res - x % 10) / 10 != preRes)
                return 0;
            preRes = res;
            x /= 10;
        }

        return res;
    }
}