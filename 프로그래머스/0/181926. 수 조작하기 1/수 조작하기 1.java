class Solution {
    public int solution(int n, String control) {
        String[] arr = control.split("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("w")) n ++;
            else if (arr[i].equals("s")) n --;
            else if (arr[i].equals("d")) n += 10;
            else if (arr[i].equals("a")) n -= 10;
        }
        return  n;
    }
}