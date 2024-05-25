class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] charA1 = str1.toCharArray();
        char[] charA2 = str2.toCharArray();
        for (int i = 0; i < charA1.length; i++) {
            char char1 = charA1[i];
            char char2 = charA2[i];
            answer += char1;
            answer += char2;
        }
        return answer;
    }
}