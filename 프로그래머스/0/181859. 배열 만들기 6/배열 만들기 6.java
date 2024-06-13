import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        StringBuilder stk = new StringBuilder();
        stk.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int lastElement = stk.length() > 0 ? Character.getNumericValue(stk.charAt(stk.length() - 1)) : -1;
            if (arr[i] != lastElement) {
                stk.append(arr[i]);
            } else {
                stk.setLength(Math.max(stk.length() - 1, 0));
            }
        }

        if (stk.length() == 0) {
            return new int[]{-1};
        }

        return Arrays.stream(stk.toString().split("")).mapToInt(Integer::parseInt).toArray();
    }
}