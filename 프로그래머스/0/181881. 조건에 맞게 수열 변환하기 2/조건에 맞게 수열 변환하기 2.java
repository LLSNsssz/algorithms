import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        int[] arr0 = new int[arr.length];
        Arrays.fill(arr0, -1);
        
        while(!Arrays.equals(arr0, arr)) {
            arr0 = Arrays.copyOf(arr, arr.length);
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                arr[i] = arr[i] / 2;
                } else if(arr[i] < 50 && arr[i] % 2 == 1) {
                arr[i] = arr[i] * 2 + 1;
                }
            }
            
            if(!Arrays.equals(arr0, arr)){
                count++;
            }
        }
        return count;
    }
}