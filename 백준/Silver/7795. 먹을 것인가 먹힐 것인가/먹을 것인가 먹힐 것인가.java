import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(T-- > 0) {
            // 입력 처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int[] A = new int[N];
            int[] B = new int[M];
            
            // A 배열 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            // B 배열 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            
            // 정렬
            Arrays.sort(A);
            Arrays.sort(B);
            
            // A의 각 원소에 대해 B의 원소 중 작은 것의 개수 계산
            int count = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M && B[j] < A[i]; j++) {
                    count++;
                }
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.print(sb);
    }
}