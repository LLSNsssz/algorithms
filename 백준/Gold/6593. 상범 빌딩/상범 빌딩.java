import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] building;
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            if(L == 0 && R == 0 && C == 0) break;
            
            building = new char[L][R][C];
            Point start = null;
            
            // 빌딩 정보 입력
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for(int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if(building[i][j][k] == 'S') 
                            start = new Point(i, j, k, 0);
                    }
                }
                br.readLine(); // 층 사이 빈 줄
            }
            
            int result = bfs(start);
            sb.append(result == -1 ? "Trapped!" : 
                     "Escaped in " + result + " minute(s).").append("\n");
        }
        
        System.out.print(sb);
    }
    
    static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[L][R][C];
        
        queue.offer(start);
        visited[start.z][start.y][start.x] = true;
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            
            if(building[cur.z][cur.y][cur.x] == 'E') {
                return cur.time;
            }
            
            for(int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) continue;
                if(visited[nz][ny][nx] || building[nz][ny][nx] == '#') continue;
                
                queue.offer(new Point(nz, ny, nx, cur.time + 1));
                visited[nz][ny][nx] = true;
            }
        }
        return -1;
    }
    
    static class Point {
        int z, y, x, time;
        Point(int z, int y, int x, int time) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}