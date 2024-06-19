class Solution {
    public int[][] solution(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        
        if (row > col) {
            int temp[][] = new int[row][row];
            for(int i = 0; i < row; i++) {
                for(int l = 0; l < col; l++) {
                    temp[i][l] = arr[i][l];
                }
                temp[i][col] = 0;
            }
            return temp;
        } else if (col > row) {
            int temp[][] = new int[col][col];
            for(int i = 0; i < col; i++) {
                for(int l = 0; l < row; l++) {
                    temp[l][i] = arr[l][i];
                }
                temp[row][i] = 0;
            }
            return temp;
        } else {
            return arr;
        }
    }
}