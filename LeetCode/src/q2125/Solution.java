package q2125;

public class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0;
        int prev = 0;

        for (int i = 0; i < bank.length; i++) {
            int count = countDevices(bank[i]);
            if (count != 0) {
                sum += prev * count;
                prev = count;
            }
        }
        return sum;
    }

    public int countDevices(String devices) {
        int sum = 0;
        for (char device : devices.toCharArray()) {
            sum += device - '0';
        }
        return sum;
    }
}