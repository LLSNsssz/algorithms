import java.io.*;

public class Main {
    static final int MOD = 1_000_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // n이 0인 경우 특별 처리
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }
        
        // n의 절대값만큼의 배열 생성
        int size = Math.abs(n);
        long[] fibo = new long[size + 1];
        
        // 기본값 설정
        fibo[0] = 0;
        fibo[1] = 1;
        
        // 피보나치 수열 계산
        for (int i = 2; i <= size; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % MOD;
        }
        
        // 결과값 계산
        long result = fibo[size];
        
        // 음수 인덱스인 경우 처리
        if (n < 0 && n % 2 == 0) {
            result = -result;
        }
        
        // 부호 출력
        System.out.println(result == 0 ? 0 : (result > 0 ? 1 : -1));
        // 절대값을 MOD로 나눈 나머지 출력
        System.out.println(Math.abs(result));
    }
}