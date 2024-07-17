import java.io.*;
import java.util.*;

public class Main {
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;
    static int[] arr;  // 각 학생이 선택한 학생의 번호를 저장
    static int[] state;  // 각 학생의 방문 상태를 저장
    static int n;  // 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());  // 학생 수 입력
            arr = new int[n + 1];
            state = new int[n + 1];
            
            // 각 학생이 선택한 학생 번호 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            // 모든 학생에 대해 DFS 실행
            for (int i = 1; i <= n; i++) {
                if (state[i] == NOT_VISITED) {
                    run(i);
                }
            }
            
            // 팀에 속하지 못한 학생 수 계산
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != CYCLE_IN) {
                    cnt++;
                }
            }
            
            bw.write(cnt + "\n");  // 결과 출력
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    // DFS를 수행하며 사이클을 탐지하는 함수
    static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = x;  // 현재 DFS의 시작점으로 마킹
            cur = arr[cur];  // 다음 학생으로 이동
            
            // 이번 DFS에서 이미 방문한 학생에 도달한 경우 (사이클 발견)
            if (state[cur] == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;  // 사이클에 포함된 학생들을 마킹
                    cur = arr[cur];
                }
                return;
            }
            // 이전 DFS에서 방문한 학생에 도달한 경우
            else if (state[cur] != NOT_VISITED) {
                return;
            }
        }
    }
}