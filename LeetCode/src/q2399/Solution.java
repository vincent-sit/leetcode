package q2399;

public class Solution {
    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0; i < distance.length; i++) {
            char c = (char) (i + 'a');
            if ((distance[i] == 0 && s.indexOf(c) == -1) || (distance[i] != 0 && s.indexOf(c) == -1)) {
                continue;
            }

            int dis = distance[i];
            int firstPos = s.indexOf(c);
            int secondPos = s.indexOf(c, firstPos + 1);
            if (secondPos - firstPos - 1 != dis) {
                return false;
            }
        }
        return true;
    }
}