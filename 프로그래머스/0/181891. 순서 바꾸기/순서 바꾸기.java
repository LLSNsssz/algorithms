import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = {};
        int[] arr1 = Arrays.copyOfRange(num_list, 0, n);
        int[] arr2 = Arrays.copyOfRange(num_list, n, num_list.length);
        
        List<Integer> list = new ArrayList<>();
        for(int i : arr2) {
            list.add(i);
        }
        for(int i : arr1) {
            list.add(i);
        }
        
        return answer = list.stream().mapToInt(Integer::intValue).toArray();
    }
}