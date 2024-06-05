import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        // int answer = 0;
        // int oddSum = 0, evenSum = 0;
        // for(int i = 0; i < num_list.length; i += 2) {
        //     oddSum += num_list[i];
        // }
        // for(int i = 1; i < num_list.length; i += 2) {
        //     evenSum += num_list[i];
        // }
        // return answer = oddSum > evenSum? oddSum : evenSum;
        int oddSum = IntStream.range(0, num_list.length).filter(i -> i % 2 == 0).map(i -> num_list[i]).sum();
        int evenSum = IntStream.range(1, num_list.length).filter(i -> i % 2 == 1).map(i -> num_list[i]).sum();
        return Math.max(oddSum, evenSum);
    }
}