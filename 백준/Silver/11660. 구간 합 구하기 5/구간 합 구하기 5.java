import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 표의 크기 N과 쿼리의 개수 M 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 표의 값들을 저장할 2차원 배열 (인덱스를 1부터 사용하기 위해 크기를 (n+1)로 설정)
        int[][] arr = new int[n + 1][n + 1];
        
        // 표의 값들을 2차원 배열에 입력받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 2차원 누적 합 배열 (인덱스를 1부터 사용하기 위해 크기를 (n+1)로 설정)
        int[][] prefixSum = new int[n + 1][n + 1];
        
        // 2차원 누적 합 배열 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 점화식: prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j]
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + arr[i][j];
            }
        }
        
        // 쿼리 처리
        for (int i = 0; i < m; i++) {
            // 쿼리 입력받기
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken()); 
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // (x1, y1)부터 (x2, y2)까지의 구간 합 계산
            // prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1]
            int sum = prefixSum[x2][y2] - prefixSum[x1-1][y2] - prefixSum[x2][y1-1] + prefixSum[x1-1][y1-1];
            bw.write(sum + "\n");
        }
        
        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
}