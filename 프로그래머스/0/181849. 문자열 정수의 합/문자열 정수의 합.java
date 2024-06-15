class Solution {
    public int solution(String num_str) {
        String[] str = num_str.split("");
        int answer = 0;
        for(int i = 0; i < str.length; i++) {
            int num = Integer.parseInt(str[i]);
            answer += num;
        }
              
        return answer;
    }
}