import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int N, M, H;
  static int[][][] box;
  static int[] dx = {-1, 1, 0, 0, 0, 0};
  static int[] dy = {0, 0, -1, 1, 0, 0};
  static int[] dz = {0, 0, 0, 0, -1, 1};
  static Queue<int[]> queue = new LinkedList<>();
  // 전체 토마토수와 익은 토마토수
  static int totalTomatoes = 0;
  static int ripeTomatoes = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    box = new int[H][N][M];
    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
          box[h][n][m] = Integer.parseInt(st.nextToken());
          if (box[h][n][m] != -1) totalTomatoes++; // 빈칸이 아니면 전체 토마토스 증가
          if (box[h][n][m] == 1) {
            queue.offer(new int[] {h, n, m, 0}); // 익은 토마토 위치 큐에 추가
            ripeTomatoes++; // 익은 토마토 수 증가
          }
        }
      }
    }
    bw.write(String.valueOf(bfs()));
    br.close();
    bw.flush();
    bw.close();
  }

  private static int bfs() {
    // 처음부터 모든 토마토가 익어있는 경우
    if (totalTomatoes == ripeTomatoes) return 0;

    while (!queue.isEmpty()) {
      // 현재 큐에 있는 익은 토마토들에 대해 처리
      int[] now = queue.poll();
      int z = now[0];
      int x = now[1];
      int y = now[2];
      int days = now[3];


      for (int k = 0; k < 6; k++) {
        int nz = z + dz[k];
        int nx = x + dx[k];
        int ny = y + dy[k];

        if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
          if (box[nz][nx][ny] == 0) {
            box[nz][nx][ny] = 1; // 토마토를 익힘
            queue.offer(new int[] {nz, nx, ny, days + 1}); // 새로 익은 토마토위치를 큐에 추가
            ripeTomatoes++; // 익은 토마토수 증가
            // 모든 토마토가 익었따면 날짜 반환
            if (ripeTomatoes == totalTomatoes) return days + 1;
          }
        }
      }
    }
    return -1;
  }
}
