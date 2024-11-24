import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // dp[i][j]: i번 집을 j색으로 칠했을 때의 최소 비용
        // j = 0(R), 1(G), 2(B)
        int[][] dp = new int[N][3];
        
        // 첫 번째 집의 비용 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken()); // Red
        dp[0][1] = Integer.parseInt(st.nextToken()); // Green
        dp[0][2] = Integer.parseInt(st.nextToken()); // Blue
        
        // 두 번째 집부터 DP 진행
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 각 색상별로 이전 집과 다른 색을 선택했을 때의 최소 비용 계산
            dp[i][0] = r + Math.min(dp[i-1][1], dp[i-1][2]); // Red
            dp[i][1] = g + Math.min(dp[i-1][0], dp[i-1][2]); // Green
            dp[i][2] = b + Math.min(dp[i-1][0], dp[i-1][1]); // Blue
        }
        
        // 마지막 집까지 칠했을 때의 최소 비용
        int answer = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(answer);
    }
}