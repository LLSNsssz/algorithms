import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 누적 합 배열 생성
        int[] prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }
        
        // 구간 합 계산 및 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // end까지의 누적 합 - (start-1)까지의 누적 합
            sb.append(prefixSum[end] - prefixSum[start-1]).append('\n');
        }
        
        System.out.print(sb);
    }
}