import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int result;
    
    static class Node {
        int num, dist;
        Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 트리 초기화
        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            
            tree[a].add(new Node(b, dist));
            tree[b].add(new Node(a, dist));
        }
        
        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            visited = new boolean[N + 1];
            result = 0;
            dfs(start, end, 0);
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
    
    static void dfs(int current, int end, int distance) {
        if(current == end) {
            result = distance;
            return;
        }
        
        visited[current] = true;
        for(Node next : tree[current]) {
            if(!visited[next.num]) {
                dfs(next.num, end, distance + next.dist);
            }
        }
    }
}