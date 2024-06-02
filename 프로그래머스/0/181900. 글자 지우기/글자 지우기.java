import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        String[] temp = my_string.split("");
        Arrays.sort(indices);
        int start = 0;
        for(int i = 0; i < my_string.length(); i++) {
            if(start < indices.length && i == indices[start]) {
                answer += "";
                start++;
            } else {
                answer += temp[i];
            }
        }
        return answer;
    }
}