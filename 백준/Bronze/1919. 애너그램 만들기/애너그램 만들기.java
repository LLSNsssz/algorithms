import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[] count = new int[26];
        
        // 첫 번째 단어의 각 문자 빈도수 증가
        for(char c : str1.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 두 번째 단어의 각 문자 빈도수 감소
        for(char c : str2.toCharArray()) {
            count[c - 'a']--;
        }
        
        // 제거해야 할 문자의 개수 계산
        int result = 0;
        for(int i = 0; i < 26; i++) {
            result += Math.abs(count[i]);
        }
        
        System.out.println(result);
    }
}
