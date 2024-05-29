import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(n);
        for (int i = 1; i < answer.size() + 1; i++) {
            if(answer.get(answer.size() - 1) == 1) {
                break;
            } else if (n%2 == 0){
                answer.add(n/2);
                n = answer.get(i);
            } else {
                answer.add(3 * n + 1);
                n = answer.get(i);
            }
        }
        return answer;
    }
}