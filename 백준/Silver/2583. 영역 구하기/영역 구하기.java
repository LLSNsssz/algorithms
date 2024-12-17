import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new boolean[M][N];
        
        // 직사각형 영역 표시
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int y = y1; y < y2; y++) {
                for(int x = x1; x < x2; x++) {
                    map[y][x] = true;
                }
            }
        }
        
        // 영역 개수와 크기 구하기
        ArrayList<Integer> areas = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!map[i][j]) {
                    areas.add(dfs(i, j));
                }
            }
        }
        
        // 결과 출력
        Collections.sort(areas);
        System.out.println(areas.size());
        for(int area : areas) {
            System.out.print(area + " ");
        }
    }
    
    static int dfs(int y, int x) {
        map[y][x] = true;
        int size = 1;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < M && nx < N && !map[ny][nx]) {
                size += dfs(ny, nx);
            }
        }
        
        return size;
    }
}