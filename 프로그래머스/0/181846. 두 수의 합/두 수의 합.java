import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger sum = new BigInteger(a).add(new BigInteger(b));
        return "" + sum;
    }
}