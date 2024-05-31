class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parts.length; i++) {
            int s = parts[i][0];
            int e = parts[i][1];
            String[] in_strings = my_strings[i].split("");
            for (int j = s; j <= e; j++) {
            sb.append(in_strings[j]);
            }
        }
        return answer = new String(sb);
    }
}