class Solution {
    public String solution(String n_str) {
        int index = 0;
        for(int i = 0; i < n_str.length(); i++) {
            if (n_str.charAt(index) == '0') {
                index = i;
            } else {
                break;
            }
        }
        return n_str.substring(index);
    }
}