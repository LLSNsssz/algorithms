import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        BigInteger bi1 = new BigInteger(number);
        BigInteger bi2 = new BigInteger("9");
        
        return bi1.remainder(bi2).intValue();
    }
}