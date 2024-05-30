class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        boolean answer = true;
       
        boolean X1 = x1 == x2?x1:true;
        boolean X2 = x3 == x4?x3:true;
      
        return answer = X1 == X2?X1:false;
    }
}