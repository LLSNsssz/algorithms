import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] snacks;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); // 조카의 수
        N = Integer.parseInt(st.nextToken()); // 과자의 수
        
        snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int maxLength = 0;
        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            maxLength = Math.max(maxLength, snacks[i]);
        }
        
        // 이분 탐색
        long left = 1;
        long right = maxLength;
        long answer = 0;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            if(canShare(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    // 길이가 length일 때 M명에게 나눠줄 수 있는지 확인
    static boolean canShare(long length) {
        if(length == 0) return false;
        
        long count = 0;
        for(int snack : snacks) {
            count += snack / length;
        }
        
        return count >= M;
    }
}