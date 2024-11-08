import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (true) {
            // 현재 합이 S보다 작으면 end 포인터를 이동
            if (sum < S) {
                if (end >= N) break;
                sum += arr[end++];
            }
            // 현재 합이 S 이상이면 start 포인터를 이동
            else {
                minLength = Math.min(minLength, end - start);
                sum -= arr[start++];
            }
        }
        
        // 가능한 부분합이 없는 경우
        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}