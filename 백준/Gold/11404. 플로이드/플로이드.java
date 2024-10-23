import java.io.*;
import java.util.*;

/**
 * 백준 11404 - 플로이드
 * 플로이드-워셜 알고리즘을 사용하여 모든 도시 쌍 사이의 최소 비용을 구하는 프로그램
 * 
 * @author Claude
 * @version 1.0
 * @see <a href="https://www.acmicpc.net/problem/11404">https://www.acmicpc.net/problem/11404</a>
 */
public class Main {
    /** 무한대 값 설정 */
    static final int INF = 987654321;
    
    /**
     * 플로이드-워셜 알고리즘을 실행하는 메인 메소드
     * 
     * @param args 커맨드 라인 인자 (사용하지 않음)
     * @throws IOException 입출력 예외 발생 가능
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 도시의 개수 입력
        int n = Integer.parseInt(br.readLine());
        // 버스의 개수 입력
        int m = Integer.parseInt(br.readLine());
        
        // 거리 행렬 초기화
        int[][] dist = new int[n + 1][n + 1];
        
        // 거리 행렬을 무한대로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                dist[i][j] = INF;
            }
        }
        
        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 시작 도시와 도착 도시를 연결하는 노선이 여러 개일 수 있으므로
            // 최소 비용을 저장
            dist[a][b] = Math.min(dist[a][b], c);
        }
        
        // 플로이드-워셜 알고리즘 수행
        floydWarshall(dist, n);
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    /**
     * 플로이드-워셜 알고리즘 구현 메소드
     * 모든 정점에서 모든 정점으로의 최단 경로를 구함
     * 
     * @param dist 거리 행렬
     * @param n 도시의 개수
     */
    private static void floydWarshall(int[][] dist, int n) {
        // k: 거쳐가는 노드
        for (int k = 1; k <= n; k++) {
            // i: 출발 노드
            for (int i = 1; i <= n; i++) {
                // j: 도착 노드
                for (int j = 1; j <= n; j++) {
                    // i에서 k를 거쳐 j로 가는 비용이 기존 비용보다 작으면 갱신
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}