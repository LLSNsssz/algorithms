class Solution {
    public int solution(String my_string, String target) {
        boolean isSubstring = my_string.contains(target);
        if(isSubstring == true) {
            return 1;
        } else {
            return 0;
        }
    }
}