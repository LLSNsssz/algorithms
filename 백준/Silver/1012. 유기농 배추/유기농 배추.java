import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};
  static boolean[][] visited;
  static int[][] Array;
  static int T, M, N, K, X, Y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      Array = new int[N][M];
      visited = new boolean[N][M];
      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Array[Y][X] = 1;
      }
      int count = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (Array[i][j] == 1 && !visited[i][j]) {
            BFS(i, j);
            count++;
          }
        }
      }
      bw.write(count + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static void BFS(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {i, j});
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int now[] = queue.poll();
      for (int k = 0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];
        if (x >= 0 && y >= 0 && x < N && y < M) {
          if (Array[x][y] != 0 && !visited[x][y]) {
            visited[x][y] = true;
            queue.add(new int[] {x, y});
          }
        }
      }
    }
  }
}
