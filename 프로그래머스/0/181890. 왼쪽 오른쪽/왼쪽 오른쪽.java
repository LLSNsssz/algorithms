class Solution {
    public String[] solution(String[] str_list) {
        String str = String.join("", str_list);
        int lIdx = str.indexOf("l");
        int rIdx = str.indexOf("r");
        
        if((lIdx == -1 && rIdx == -1) || str_list.length <= 1) {
            return new String[0];
        }  else if(lIdx != -1 && (rIdx == -1 || lIdx < rIdx)) {
            return str.substring(0, lIdx).split("");
        } else if(rIdx != -1 && (lIdx == -1 || lIdx > rIdx)) {
            return str.substring(rIdx + 1).split("");
        } else {
            return new String[0];
        }
    }
}