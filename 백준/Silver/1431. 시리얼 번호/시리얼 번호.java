import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] serials = new String[N];
        for(int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }
        
        // Comparator를 사용한 정렬
        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 1. 길이가 다르면 짧은 것이 먼저
                if(s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }
                
                // 2. 길이가 같으면 자리수 합 비교 (숫자만)
                int sum1 = getSum(s1);
                int sum2 = getSum(s2);
                if(sum1 != sum2) {
                    return sum1 - sum2;
                }
                
                // 3. 사전순 비교
                return s1.compareTo(s2);
            }
            
            // 문자열에서 숫자만 더하는 메소드
            private int getSum(String s) {
                int sum = 0;
                for(char c : s.toCharArray()) {
                    if(Character.isDigit(c)) {
                        sum += c - '0';
                    }
                }
                return sum;
            }
        });
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(String serial : serials) {
            sb.append(serial).append('\n');
        }
        System.out.print(sb);
    }
}