import java.util.Arrays;
import java.util.HashSet;


class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>(Arrays.asList(a, b, c));
        if (set.size() == 3) {
            answer = a + b + c;
        } else if (set.size() == 2) {
            answer = (a + b + c) * (a*a + b*b + c*c);
        } else if (set.size() == 1) {
            answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        }
        return answer;
    }
}