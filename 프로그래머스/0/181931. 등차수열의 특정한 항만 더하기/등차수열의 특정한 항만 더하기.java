class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int[] arr = new int[included.length];
        arr[0] = a;
        if(included[0]) {
            answer += arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + d;
            if(included[i]) {
                answer += arr[i] ;    
            }
        }  
        return answer;
    }       
}
