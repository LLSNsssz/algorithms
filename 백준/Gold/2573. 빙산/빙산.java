import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] ocean;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;
        while (true) {
            int icebergs = countIcebergs();
            if (icebergs >= 2) {
                System.out.println(years);
                return;
            }
            if (icebergs == 0) {
                System.out.println(0);
                return;
            }
            meltIceberg();
            years++;
        }
    }

    static int countIcebergs() {
        boolean[][] visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ocean[nx][ny] > 0 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void meltIceberg() {
        int[][] melt = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ocean[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && ocean[nx][ny] == 0) {
                            melt[i][j]++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ocean[i][j] = Math.max(0, ocean[i][j] - melt[i][j]);
            }
        }
    }
}