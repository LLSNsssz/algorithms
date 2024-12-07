import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        result = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);  // 사전순 출력을 위한 정렬
        
        backtrack(0);
        System.out.print(sb);
    }
    
    static void backtrack(int depth) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < N; i++) {
            result[depth] = arr[i];
            backtrack(depth + 1);
        }
    }
}