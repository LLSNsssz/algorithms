import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int max = 0;
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }
        
        // 이분 탐색
        long left = 0;
        long right = max;
        long result = 0;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            // 잘린 나무 길이의 합 계산
            for(int tree : trees) {
                if(tree > mid) {
                    sum += tree - mid;
                }
            }
            
            if(sum >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}