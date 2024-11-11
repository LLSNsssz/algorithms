import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬 및 중복 제거
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : numbers) {
            set.add(num);
        }
        
        numbers = new int[set.size()];
        int idx = 0;
        for(int num : set) {
            numbers[idx++] = num;
        }
        N = numbers.length;
        
        result = new int[M];
        backtrack(0, 0);
        
        System.out.print(sb.toString());
    }
    
    static void backtrack(int depth, int start) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < N; i++) {
            result[depth] = numbers[i];
            backtrack(depth + 1, i);  // 같은 수를 여러 번 선택할 수 있으므로 i를 전달
        }
    }
}