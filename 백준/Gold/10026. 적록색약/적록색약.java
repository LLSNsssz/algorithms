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
  static char[][] grid;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    grid = new char[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        grid[i][j] = line.charAt(j);
      }
    }

    int normalCount = countAreas(false);

    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 'G') grid[i][j] = 'R';
      }
    }

    int colorBlindCount = countAreas(true);

    bw.write(normalCount + " " + colorBlindCount);

    br.close();
    bw.flush();
    bw.close();
  }

  // 적록색약일때와 아닐때 영역개수 계산
  private static int countAreas(boolean isColorBlind) {
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visited[i][j]) {
          BFS(i, j, grid[i][j]);
          count++;
        }
      }
    }
    return count;
  }

  private static void BFS(int i, int j, char color) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {i, j});

    while (!queue.isEmpty()) {
      int now[] = queue.poll();
      for (int k = 0; k < 4; k++) {
        int x = now[0] + dx[k];
        int y = now[1] + dy[k];
        if (x >= 0 && y >= 0 && x < N && y < N) {
          if (grid[x][y] == color && !visited[x][y]) {
            visited[x][y] = true;
            queue.add(new int[] {x, y});
          }
        }
      }
    }
  }
}
