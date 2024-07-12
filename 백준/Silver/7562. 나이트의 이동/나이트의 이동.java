import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int I;
  static boolean[][] visited;
  static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
  static int[] dy = {1, -1, -2, 2, -2, 2, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    while (testCase-- > 0) {
      I = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cx = Integer.parseInt(st.nextToken());
      int cy = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int nx = Integer.parseInt(st.nextToken());
      int ny = Integer.parseInt(st.nextToken());

      visited = new boolean[I][I];
      int bfs = bfs(cx, cy, nx, ny);
      bw.write(bfs + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static int bfs(int cx, int cy, int nx, int ny) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {cx, cy, 0});
    visited[cx][cy] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0];
      int y = now[1];
      int moves = now[2];

      if (x == nx && y == ny) {
        return moves;
      }

      for (int k = 0; k < 8; k++) {
        int newX = x + dx[k];
        int newY = y + dy[k];
        if (newX >= 0 && newY >= 0 && newX < I && newY < I && !visited[newX][newY]) {
          visited[newX][newY] = true;
          queue.offer(new int[] {newX, newY, moves + 1});
        }
      }
    }
    return -1;
  }
}
