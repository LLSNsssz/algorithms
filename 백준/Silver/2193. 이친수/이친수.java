import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // dp[i][j] : i자리 이친수이면서 j로 끝나는 수의 개수
        long[][] dp = new long[N + 1][2];
        
        // 1자리 이친수 초기화
        dp[1][1] = 1; // 1
        
        // 2자리 이상의 이친수 계산
        for(int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1]; // 0으로 끝나는 경우
            dp[i][1] = dp[i-1][0];              // 1로 끝나는 경우
        }
        
        System.out.println(dp[N][0] + dp[N][1]);
    }
}