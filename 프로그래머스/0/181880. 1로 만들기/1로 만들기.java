import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        return Arrays.stream(num_list).map(i -> makeOne(i)).sum();
    }
    
    private int makeOne(int n) {
        int cnt = 0;
        boolean flag = true;
        
        while(flag) {
            if(n == 1) {
                flag = false;
            } else if (n % 2 == 1){
                n = (n - 1)/2;
                cnt++;
            } else {
                n = n / 2;
                cnt++;
            }
        }
        return cnt;
    }
}