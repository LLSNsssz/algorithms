import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int x = 0;
        
        return Arrays.copyOf(arr, pow(arr.length, x));
        
    }
    
    public int pow(int length, int x) {
        if(length > Math.pow(2, x)) {
            return pow(length, ++x);
        }
        return (int)Math.pow(2, x);
    }
}