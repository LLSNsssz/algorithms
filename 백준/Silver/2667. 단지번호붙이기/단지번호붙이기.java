import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; // 상하좌우 이동
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        // 지도 정보 입력
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        ArrayList<Integer> complexes = new ArrayList<>();
        
        // 모든 위치에 대해 단지 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    complexes.add(dfs(i, j));
                }
            }
        }
        
        // 결과 출력
        Collections.sort(complexes); // 오름차순 정렬
        System.out.println(complexes.size());
        for(int count : complexes) {
            System.out.println(count);
        }
    }
    
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }
        
        return count;
    }
}