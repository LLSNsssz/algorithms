import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        result = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        backtrack(0);
        System.out.print(sb);
    }
    
    static void backtrack(int depth) {
        if(depth == M) {
            String sequence = toString(result);
            if(!set.contains(sequence)) {
                set.add(sequence);
                for(int i = 0; i < M; i++) {
                    sb.append(result[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    static String toString(int[] arr) {
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < M; i++) {
            temp.append(arr[i]).append(" ");
        }
        return temp.toString();
    }
}