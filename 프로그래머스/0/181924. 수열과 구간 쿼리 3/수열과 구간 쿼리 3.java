class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < queries.length; i++) {
            int tmp = 0;
            
            for (int j = 0; j < queries[i].length - 1; j++) {
                tmp = arr[queries[i][j]];
                arr[queries[i][j]] = arr[queries[i][j + 1]];
                arr[queries[i][j + 1]] = tmp;
            }
        }
        return arr;
    }
}