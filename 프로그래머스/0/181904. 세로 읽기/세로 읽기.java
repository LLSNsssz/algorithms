class Solution {
    public String solution(String my_string, int m, int c) {
        
        StringBuilder sb = new StringBuilder();
        String[][] newString = new String[my_string.length()/m][m];
        String str = "";
        
        
        for(int i = 0; i < my_string.length()/m; i++){
            str = my_string.substring(i * m, (i + 1) * m);
            for(int j = 0; j < m; j++) {
                newString[i][j] = "" + str.charAt(j);
            }
            sb.append(newString[i][c - 1]);
        }
        
        return sb.toString();
    }
}