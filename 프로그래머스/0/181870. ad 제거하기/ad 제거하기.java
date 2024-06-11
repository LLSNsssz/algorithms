import java.util.Arrays;

class Solution {
    public String[] solution(String[] strArr) {
        int index = 0;
        String[] answer = new String[strArr.length];
        
        for(String str : strArr) {
            if(!str.contains("ad")) {
                answer[index++] = str;
            }
        }
        return Arrays.copyOf(answer, index);
    }
}