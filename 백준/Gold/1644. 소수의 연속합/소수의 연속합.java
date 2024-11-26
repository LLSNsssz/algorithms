import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 소수 구하기 (에라토스테네스의 체)
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i * i <= N; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 소수만 리스트에 저장
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= N; i++) {
            if(isPrime[i]) {
                primes.add(i);
            }
        }
        
        // 투 포인터로 연속된 소수의 합 찾기
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        int size = primes.size();
        
        while(true) {
            if(sum >= N) {
                if(sum == N) {
                    count++;
                }
                if(start >= size) break;
                sum -= primes.get(start++);
            } else {
                if(end >= size) break;
                sum += primes.get(end++);
            }
        }
        
        System.out.println(count);
    }
}