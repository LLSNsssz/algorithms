import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < intStrs.length; i++) {
            if(Integer.parseInt(intStrs[i].substring(s, s + l)) > k) {
                list.add(Integer.parseInt(intStrs[i].substring(s, s + l)));
            }
        }
        return answer = list.stream().mapToInt(i -> i).toArray();
    }
}