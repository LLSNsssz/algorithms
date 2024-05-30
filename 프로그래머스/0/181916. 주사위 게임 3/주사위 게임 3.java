import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Set<Integer> set = new HashSet<>(Arrays.asList(a, b, c, d));
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c, d));
        
        int answer = 0;
        
        if(set.size() == 1) {
            List<Integer> listSize1 = new ArrayList<>(set);
            answer = 1111 * listSize1.get(0);
            
        } else if(set.size() == 2) {
            List<Integer> listSize2 = new ArrayList<>(set);
            
            List<Boolean> aList = new ArrayList<>();
            List<Boolean> bList = new ArrayList<>();

            for (int i = 0; i < 4;i++) {
                if (Objects.equals(list.get(i), listSize2.get(0))){
                    aList.add(true);
                } else if (Objects.equals(list.get(i), listSize2.get(1))){
                    bList.add(true);
                }
            }
            
            if(aList.size() == 3) {
                answer = (int) Math.pow(10 * listSize2.get(0) + listSize2.get(1), 2);

            } else if(bList.size() == 3) {
                answer = (int) Math.pow(10 * listSize2.get(1) + listSize2.get(0), 2);

            } else if(aList.size() == 2 && bList.size() == 2){
                answer = (listSize2.get(0) + listSize2.get(1)) * Math.abs(listSize2.get(0) - listSize2.get(1));
                
            } 
 
        } else if(set.size() == 3) {
            List<Integer> listSize3 = new ArrayList<>(set);
        
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (Objects.equals(list.get(i), list.get(j))){
                        listSize3.remove(new Integer(list.get(i)));
                    } 
                } 
            }
            answer = listSize3.get(0) * listSize3.get(1);
            
        } else if(set.size() == 4) {
            Collections.sort(list);
            answer = list.get(0);
        }

        return answer;
    }
}