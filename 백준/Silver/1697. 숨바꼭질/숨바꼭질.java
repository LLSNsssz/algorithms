import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치
        
        System.out.println(bfs(N, K));
    }
    
    public static int bfs(int start, int target) {
        if (start == target) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] time = new int[100001];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 다음 위치들을 검사
            int[] next = {current - 1, current + 1, current * 2};
            
            for (int nextPos : next) {
                if (nextPos < 0 || nextPos > 100000) continue;
                if (visited[nextPos]) continue;
                
                queue.offer(nextPos);
                visited[nextPos] = true;
                time[nextPos] = time[current] + 1;
                
                if (nextPos == target) {
                    return time[nextPos];
                }
            }
        }
        
        return -1; // 도달할 수 없는 경우 (실제로는 발생하지 않음)
    }
}