import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
    

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strArr.length; i++) {
            int value = strArr[i].length();
            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(strArr[i]);
        }
        
        int maxSize = 0;
        
        for(List<String> list : map.values()) {
            if(list.size() > maxSize) {
                maxSize = list.size();
            }
        }
        return maxSize;
    }
}