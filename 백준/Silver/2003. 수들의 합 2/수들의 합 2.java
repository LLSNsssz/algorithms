import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투 포인터 알고리즘 적용
        int count = 0;      // M이 되는 경우의 수
        int sum = 0;        // 현재 부분합
        int start = 0;      // 시작 포인터
        int end = 0;        // 끝 포인터
        
        while(true) {
            // 현재 합이 M보다 크면 start를 증가
            if(sum >= M) {
                sum -= arr[start++];
            }
            // end가 배열 끝에 도달하면 종료
            else if(end == N) {
                break;
            }
            // 현재 합이 M보다 작으면 end를 증가
            else {
                sum += arr[end++];
            }
            
            // 현재 합이 M과 같으면 count 증가
            if(sum == M) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}