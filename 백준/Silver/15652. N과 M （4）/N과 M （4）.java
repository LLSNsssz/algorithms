import java.io.*;
import java.util.*;

/**
 * 백준 15652번 N과 M (4) 문제 해결 클래스
 * 백트래킹 알고리즘을 사용하여 조건을 만족하는 수열을 생성합니다.
 */
public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    /**
     * 메인 메소드: 프로그램의 진입점
     * 입력을 받고 백트래킹 알고리즘을 시작합니다.
     *
     * @param args 커맨드 라인 인자 (사용하지 않음)
     * @throws IOException 입력 처리 중 발생할 수 있는 예외
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1, 0);
        System.out.print(sb);
    }

    /**
     * 깊이 우선 탐색(DFS)을 사용한 백트래킹 메소드
     * 조건을 만족하는 모든 수열을 생성합니다.
     *
     * @param start 현재 탐색을 시작할 숫자
     * @param depth 현재 수열의 길이 (재귀 깊이)
     */
    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }
}