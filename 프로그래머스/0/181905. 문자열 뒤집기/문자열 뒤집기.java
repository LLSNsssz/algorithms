class Solution {
    public String solution(String my_string, int s, int e) {
        String[] newString = my_string.split("");
        String temp = "";
        
        for(int i = s; s <= e; i++) {
            temp = newString[s];
            newString[s] = newString[e];
            newString[e] = temp;
            s++;
            e--;
        }
        
        return my_string.join("", newString);
    }
}