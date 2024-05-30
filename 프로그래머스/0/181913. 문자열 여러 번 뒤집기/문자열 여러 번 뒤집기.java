class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] my_char = my_string.toCharArray();
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            char temp;
            for(int i = s; i <= e; i++) {
                temp = my_char[s];
                my_char[s] = my_char[e];
                my_char[e] = temp;
                s++;
                e--;
            }
        }
        return new String(my_char);
    }
}