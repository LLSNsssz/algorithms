import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[100001];  // 각 숫자의 등장 횟수
        int start = 0, end = 0;
        int maxLen = 0;
        
        while(end < N) {
            // end 포인터를 이동하면서 숫자 추가
            while(end < N && count[arr[end]] + 1 <= K) {
                count[arr[end]]++;
                end++;
            }
            
            // 현재 구간의 길이 계산
            maxLen = Math.max(maxLen, end - start);
            
            // start 포인터 이동
            if(end < N) {
                while(start < end && count[arr[end]] + 1 > K) {
                    count[arr[start]]--;
                    start++;
                }
            }
        }
        
        System.out.println(maxLen);
    }
}