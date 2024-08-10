import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 총 일수 N 입력받기
        int N = Integer.parseInt(br.readLine());
        
        // 상담 정보 입력받기 (Ti: 상담 기간, Pi: 상담 수익)
        int[] Ti = new int[N + 1];
        int[] Pi = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }
        
        // 동적 계획법으로 최대 이익 계산
        int[] dp = new int[N + 2]; // dp[i] = i번째 날부터 마지막 날까지 낼 수 있는 최대 이익
        for (int i = N; i > 0; i--) {
            int nextDay = i + Ti[i]; // 현재 상담이 끝나는 날짜
            
            // 상담이 기간 내에 끝나는 경우
            if (nextDay <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[nextDay] + Pi[i]);
            }
            // 상담이 기간을 벗어나는 경우
            else {
                dp[i] = dp[i + 1];
            }
        }
        
        // 최대 이익 출력
        bw.write(dp[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}