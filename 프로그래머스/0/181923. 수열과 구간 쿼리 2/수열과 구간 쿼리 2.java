import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] tmp = new int[queries[i][1] - queries[i][0] + 1];
            System.arraycopy(arr, queries[i][0], tmp, 0, tmp.length);
            Arrays.sort(tmp);
            boolean found = false;
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] > queries[i][2]) {
                    answer[i] = tmp[j];
                    found = true;
                    break;
                }
            } 
            if (!found) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
