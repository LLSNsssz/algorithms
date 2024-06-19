import java.util.Arrays;

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int[] arr : answer) {        
            Arrays.fill(arr,0);
        }
        for(int i =0; i < answer.length; i++) {
            for(int j = 0; j < answer[i].length; j++) {
                if(i == j) {
                    answer[i][j] = 1;
                } else {
                    continue;
                }
            }
        }
        return answer;
    }
}