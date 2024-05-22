import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        String lowerCase = "[a-z]";
        String upperCase = "[A-Z]";

        for (int i = 0; i < chars.length; i++) {
            String currentChar = String.valueOf(chars[i]);
            if (currentChar.matches(lowerCase)) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else if (currentChar.matches(upperCase)) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        System.out.println(chars);
    }
}