import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int count = 0, start = 0, end = 0;
        for (int i  = 0; i < arr.length; i++) {
            if (arr[i] == 2 && count == 0) {
                start = i;
                end = i;
                count++;
            } else if (arr[i] == 2 && count != 0) {
                end = i;
            }
        }
        if (count == 0) {
            answer = new int[]{-1};
        } else if (start == end){
            answer = new int[]{2};
        } else {
            answer = Arrays.copyOfRange(arr, start, end + 1);
    
        }
        return answer;
    }
}