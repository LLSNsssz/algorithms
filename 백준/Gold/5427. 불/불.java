import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  static int w, h;
  static int[][] sangGunEscape;
  static int[][] fireSpread;
  static char[][] building;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    while (testCase-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      building = new char[h][w];
      fireSpread = new int[h][w];
      sangGunEscape = new int[h][w];
      Queue<int[]> fireQueue = new LinkedList<>();
      Queue<int[]> sangGunQueue = new LinkedList<>();

      for (int i = 0; i < h; i++) {
        String line = br.readLine();
        for (int j = 0; j < w; j++) {
          building[i][j] = line.charAt(j);
          // 모든 위치의 초기 거리를 최대값으로 설정
          fireSpread[i][j] = Integer.MAX_VALUE;
          sangGunEscape[i][j] = Integer.MAX_VALUE;
          if (building[i][j] == '*') { // 불의 시작위치
            fireQueue.offer(new int[] {i, j});
            fireSpread[i][j] = 0; // 불의 시작 위치의 거리를 0으로 설정
          } else if (building[i][j] == '@') {
            sangGunQueue.offer(new int[] {i, j});
            sangGunEscape[i][j] = 0; // 상근이의 시작 위치의 거리를 0으로 설정
          }
        }
      }

      // 불 확산 시뮬레이션
      fireBfs(fireQueue);
      // 상근이 탈출 시뮬레이션
      int result = sangGunBfs(sangGunQueue);

      if (result == -1) {
        bw.write("IMPOSSIBLE\n");
      } else {
        bw.write(result + "\n");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static void fireBfs(Queue<int[]> queue) {
    while (!queue.isEmpty()) {
      int[] now = queue.poll(); // 큐에서 현재 위치를 꺼냄
      int x = now[0];
      int y = now[1];

      // 상하좌우 네 방향에 대해 반복
      for (int k = 0; k < 4; k++) {
        int newX = x + dx[k];
        int newY = y + dy[k];
        // 새로운 위치가 범위를 벗어나거나, 벽이거나 , 이미 더 빠른 경로가 있으면 건너 뜀
        if (newX < 0 || newY < 0 || newX >= h || newY >= w) continue;
        if (building[newX][newY] == '#' || fireSpread[newX][newY] <= fireSpread[x][y] + 1) {
          continue;
        }
        fireSpread[newX][newY] = fireSpread[x][y] + 1; // 새로운 위치까지의 거리 갱신
        queue.offer(new int[] {newX, newY}); // 새로운 위치를 큐에 추가
      }
    }
  }

  private static int sangGunBfs(Queue<int[]> queue) {
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int x = now[0];
      int y = now[1];

      for (int k = 0; k < 4; k++) {
        int newX = x + dx[k];
        int newY = y + dy[k];
        // 새로운 위치가 범위를 벗어나면 탈출 성공
        if (newX < 0 || newY < 0 || newX >= h || newY >= w){ return sangGunEscape[x][y] + 1;}
        // 새로운 위치가 벽이거나, 이미 더 빠른경로가 있거나, 불이 먼저 도착하면 건너뜀
        if (building[newX][newY] == '#' || sangGunEscape[newX][newY] <= sangGunEscape[x][y] + 1)
          continue;
        if (fireSpread[newX][newY] <= sangGunEscape[x][y] + 1) continue;
        sangGunEscape[newX][newY] = sangGunEscape[x][y] + 1;// 새로운 위치까지의 거리 갱신
        queue.offer(new int[] {newX, newY});
      }
    }
    return -1; // 큐가 비었는데 탈출하지못했으면 탈출 실패
  }
}
