import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        
        System.out.println(KMP(S, P));
        br.close();
    }
    
    // KMP 알고리즘
    static int KMP(String str, String pattern) {
        int[] pi = getPi(pattern);
        
        int n = str.length();
        int m = pattern.length();
        int j = 0;
        
        for (int i = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                if (j == m-1) {
                    return 1;    // 패턴을 찾았으면 1 반환
                } else {
                    j++;
                }
            }
        }
        return 0;   // 패턴을 찾지 못했으면 0 반환
    }
    
    // 실패 함수 구하기
    static int[] getPi(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int j = 0;
        
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}