import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        int idx = 0;
        
        int length1 = intervals[0][1] - intervals[0][0] + 1;
        int length2 = intervals[1][1] - intervals[1][0] + 1;
        
        int[] arr1 = Arrays.copyOfRange(arr, intervals[0][0], intervals[0][1] + 1);
        int[] arr2 = Arrays.copyOfRange(arr, intervals[1][0], intervals[1][1] + 1);
        int[] arr3 = new int[length1 + length2];
        
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        
        return answer = arr3;
    }
}