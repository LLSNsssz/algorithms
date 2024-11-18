import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // dp[i]: i를 1로 만들기 위한 최소 연산 횟수
        int[] dp = new int[N + 1];
        // prev[i]: i에서 이전 숫자로 가는 경로 저장
        int[] prev = new int[N + 1];
        
        // Bottom-up 방식으로 dp 배열 채우기
        for(int i = 2; i <= N; i++) {
            // 먼저 1을 빼는 경우
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;
            
            // 2로 나누어 떨어지는 경우
            if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }
            
            // 3으로 나누어 떨어지는 경우
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }
        }
        
        // 최소 연산 횟수 출력
        System.out.println(dp[N]);
        
        // 경로 출력
        StringBuilder sb = new StringBuilder();
        for(int i = N; i >= 1; i = prev[i]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}