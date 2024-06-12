import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(myStr.split("[abc]")));
        String[] result = list.stream().filter(i -> !i.isEmpty()).toArray(String[]::new);
        return result.length == 0 ? new String[]{"EMPTY"} : result;     
    }
}