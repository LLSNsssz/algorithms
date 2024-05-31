import java.util.Arrays;

class Solution {
    public String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        int count = my_string.length() - 1;
        for(int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(my_string.length() - count - 1);
            count--;
        }
        Arrays.sort(answer);
        return answer;
    }
}