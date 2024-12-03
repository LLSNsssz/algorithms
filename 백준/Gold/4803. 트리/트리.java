import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int caseNum = 1;
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(n == 0 && m == 0) break;
            
            // 그래프 초기화
            graph = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            // 간선 정보 입력
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int trees = countTrees();
            
            sb.append("Case ").append(caseNum).append(": ");
            if(trees == 0) {
                sb.append("No trees.");
            } else if(trees == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(trees).append(" trees.");
            }
            sb.append("\n");
            
            caseNum++;
        }
        
        System.out.print(sb);
    }
    
    static int countTrees() {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                if(dfs(i, 0)) count++;
            }
        }
        return count;
    }
    
    static boolean dfs(int node, int parent) {
        visited[node] = true;
        
        for(int next : graph[node]) {
            if(next == parent) continue;
            if(visited[next]) return false; // 사이클 발견
            if(!dfs(next, node)) return false;
        }
        
        return true;
    }
}