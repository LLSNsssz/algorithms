class Solution {
    public int solution(String[] order) {
        int americanoCount = 0;
        int cafelatteCount = 0;
        for(int i = 0; i < order.length; i++) {
            if(order[i].contains("cafelatte")) {
                cafelatteCount++;
            } else {
                americanoCount++;
            }
        }
        return americanoCount * 4500 + cafelatteCount * 5000;
    }
}