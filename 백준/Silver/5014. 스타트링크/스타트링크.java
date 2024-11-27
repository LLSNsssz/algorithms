import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken()); // 최고층
        S = Integer.parseInt(st.nextToken()); // 현재층
        G = Integer.parseInt(st.nextToken()); // 목표층
        U = Integer.parseInt(st.nextToken()); // 위로 U층
        D = Integer.parseInt(st.nextToken()); // 아래로 D층
        
        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result);
    }
    
    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[F + 1];
        Arrays.fill(visited, -1);
        
        queue.offer(S);
        visited[S] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == G) {
                return visited[current];
            }
            
            // 위로 U층
            int up = current + U;
            if (up <= F && visited[up] == -1) {
                queue.offer(up);
                visited[up] = visited[current] + 1;
            }
            
            // 아래로 D층
            int down = current - D;
            if (down >= 1 && visited[down] == -1) {
                queue.offer(down);
                visited[down] = visited[current] + 1;
            }
        }
        
        return -1;
    }
}