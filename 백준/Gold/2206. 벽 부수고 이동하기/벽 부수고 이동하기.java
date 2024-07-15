import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int N, M;
  static int[][] map;
  static int[][][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new int[N][M][2];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    bw.write(String.valueOf(bfs()));
    br.close();
    bw.flush();
    bw.close();
  }

  private static int bfs() {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {0, 0, 0});
    visited[0][0][0] = 1;
    // visited[x][y][0] 벽을 부수지 않고 도달한고 도달한 경우의 거리
    // visited[x][y][1] 벽을 한 번 부수고 도달한 경우의 거리

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0], y = now[1], broke = now[2];

      // 목적지에 도달한 경우
      if (x == N -1 && y == M -1){
        return visited[x][y][broke];
      }

      for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0  && nx < N && ny >= 0 && ny < M){
          // 이동할 수 있는 곳이고 아직 방문하지 않은 경우
          if (map[nx][ny] == 0 && visited[nx][ny][broke] == 0){
            visited[nx][ny][broke] = visited[x][y][broke] + 1;
            queue.offer(new int[] {nx, ny, broke});
          }
          // 벽이고 아직 벽을 부수지 않은 경우
          else if(map[nx][ny] == 1 && broke == 0 && visited[nx][ny][1] == 0){
            visited[nx][ny][1] = visited[x][y][broke] + 1;
            queue.offer(new int[] {nx, ny, 1});
          }
        }
      }
    }
    return -1;
  }
}
