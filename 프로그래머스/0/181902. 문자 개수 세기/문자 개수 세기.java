import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        Arrays.fill(answer, 0);
        
        char[] c = my_string.toCharArray();
        
        for(int i = 0; i < c.length; i++) {
            for(int j = 65; j <= 90; j++) {
                if(c[i] == (char) j) {
                    answer[j - 65]++;
                }
            }
            for(int k = 97; k <= 122; k++) {
                if(c[i] == (char) k) {
                    answer[k - 'a' + 26]++;
                }
            }
        }
        return answer;
    }
}