import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[n][n];
        // 첫 번째 값 입력
        dp[0][0] = Integer.parseInt(br.readLine());
        
        // 삼각형 입력받으면서 DP 진행
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                int current = Integer.parseInt(st.nextToken());
                
                if(j == 0) { // 왼쪽 끝
                    dp[i][j] = dp[i-1][j] + current;
                }
                else if(j == i) { // 오른쪽 끝
                    dp[i][j] = dp[i-1][j-1] + current;
                }
                else { // 중간 위치
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + current;
                }
            }
        }
        
        // 마지막 줄에서 최대값 찾기
        int max = 0;
        for(int j = 0; j < n; j++) {
            max = Math.max(max, dp[n-1][j]);
        }
        
        System.out.println(max);
    }
}