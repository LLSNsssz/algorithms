class Solution {
    public int solution(int a, int b) {
        int lengthA = (int) (Math.log10(a) + 1);
        int lengthB = (int) (Math.log10(b) + 1);
        
        double firstA = (a * Math.pow(10, lengthB)) + b;
        double firstB = (b * Math.pow(10, lengthA)) + a;
        
        if (firstA >= firstB) {
            return (int) firstA;
        } else {
            return (int) firstB;
        }
    }
}