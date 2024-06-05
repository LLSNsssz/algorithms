class Solution {
    public int solution(int[] numbers, int n) {
        int sum = 0;
        int count = 0;
        while(sum <= n) {
            sum += numbers[count];
            count++;
        }
        return sum;
    }
}