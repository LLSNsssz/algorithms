import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length; i++) {
            if (i != b.length - 1) {
                System.out.println(b[i]);
            } else {
                System.out.print(b[i] + "\n");
            }
        }
    }
}