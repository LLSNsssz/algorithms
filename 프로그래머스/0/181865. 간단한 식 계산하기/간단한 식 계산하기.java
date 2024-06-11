class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
        int a = Integer.parseInt(str[0]);
        String op = str[1];
        int b = Integer.parseInt(str[2]);
        
        int result = 0;
        switch(op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
                
            case "*":
                result = a * b;
                break;
                
        }
        
        return result;
    }
}