import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        int maxHeight = 0;
        
        // 지도 정보 입력 및 최대 높이 찾기
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        
        int result = 1; // 아무 지역도 물에 잠기지 않는 경우도 고려
        
        // 각 높이별로 안전 영역 개수 계산
        for(int height = 1; height < maxHeight; height++) {
            visited = new boolean[N][N];
            int count = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] > height) {
                        dfs(i, j, height);
                        count++;
                    }
                }
            }
            
            result = Math.max(result, count);
        }
        
        System.out.println(result);
    }
    
    static void dfs(int x, int y, int height) {
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visited[nx][ny] && map[nx][ny] > height) {
                    dfs(nx, ny, height);
                }
            }
        }
    }
}