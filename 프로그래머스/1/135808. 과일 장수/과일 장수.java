import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int[] oneBox = new int[m];
        Integer[] integerScore = new Integer[score.length];
        for(int i = 0; i < score.length; i++) {
            integerScore[i] = score[i];
        }
        Arrays.sort(integerScore, (a, b) -> b - a);
        
        int result = 0;
        for(int i = m - 1; i < score.length; i += m) {
            result += integerScore[i] * m;
        }
        
        return result;
    }
}