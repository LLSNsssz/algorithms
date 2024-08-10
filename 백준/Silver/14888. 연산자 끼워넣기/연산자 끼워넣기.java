import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] operators;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 수열의 길이 n 입력받기
        n = Integer.parseInt(br.readLine());
        
        // 수열 nums 입력받기
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력받기 (+, -, *, /)
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // 백트래킹 시작 (초기 상태: 인덱스 1, 첫 번째 숫자)
        backtrack(1, nums[0]);

        // 최댓값과 최솟값 출력
        bw.write(maxResult + "\n" + minResult);
        bw.flush();
        bw.close();
        br.close();
    }

    static void backtrack(int idx, int result) {
        // 수열의 끝에 도달한 경우
        if (idx == n) {
            // 현재 결과값으로 최댓값과 최솟값 갱신
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        // 연산자 배치 경우의 수 탐색
        for (int i = 0; i < 4; i++) {
            // 현재 연산자의 개수가 0보다 큰 경우
            if (operators[i] > 0) {
                // 연산자 개수 감소
                operators[i]--;

                // 선택한 연산자에 따라 계산 수행
                switch (i) {
                    case 0: backtrack(idx + 1, result + nums[idx]); break;
                    case 1: backtrack(idx + 1, result - nums[idx]); break;
                    case 2: backtrack(idx + 1, result * nums[idx]); break;
                    case 3: 
                        if (result < 0) {
                            backtrack(idx + 1, (Math.abs(result) / nums[idx]) * -1); 
                        } else {
                            backtrack(idx + 1, result / nums[idx]);
                        }
                        break;
                }

                // 연산자 개수 원래대로 복구
                operators[i]++;
            }
        }
    }
}