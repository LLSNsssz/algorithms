import java.util.TreeMap;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]){                
                map.put(rank[i], i);
            }
        }
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = map.get(map.firstKey());
            map.remove(map.firstKey());
        }
        
        return arr[0] * 10000 + arr[1] * 100 + arr[2];
    }
}