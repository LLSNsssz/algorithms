import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        dfs(1, 0);
        
        System.out.print(sb);
    }
    
    static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        // start부터 시작하여 오름차순 유지
        for(int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);  // 다음 숫자는 현재 선택한 숫자보다 큰 수만 고려
        }
    }
}