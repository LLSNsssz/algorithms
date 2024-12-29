import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       
       while(T-- > 0) {
           int N = Integer.parseInt(br.readLine());
           int[] prices = new int[N];
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int i = 0; i < N; i++) {
               prices[i] = Integer.parseInt(st.nextToken());
           }
           
           // 뒤에서부터 가장 큰 값을 확인하며 처리
           long profit = 0;
           int maxPrice = prices[N-1];
           
           for(int i = N-2; i >= 0; i--) {
               if(prices[i] < maxPrice) {
                   profit += maxPrice - prices[i];
               } else {
                   maxPrice = prices[i];
               }
           }
           
           System.out.println(profit);
       }
   }
}