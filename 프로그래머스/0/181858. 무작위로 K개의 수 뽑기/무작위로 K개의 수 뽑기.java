import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList());
        for(int a : arr) {
            set.add(a);
        }
        
        int[] answer = new int[k];
        int idx = 0;
        for(int b : set) {
            if(idx < k) {                
                answer[idx++] = b;
            } else {
                break;
            }
        }
        
        if(idx < k) {
            Arrays.fill(answer, idx, k, -1);
        }
        return answer;
    }
}