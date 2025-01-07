import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       
       int[] scores = new int[N];
       for(int i = 0; i < N; i++) {
           scores[i] = Integer.parseInt(br.readLine());
       }
       
       int count = 0;
       for(int i = N-2; i >= 0; i--) {
           // 현재 점수가 다음 레벨 점수보다 크거나 같으면
           if(scores[i] >= scores[i+1]) {
               // 다음 레벨보다 1 작게 만듦
               int diff = scores[i] - scores[i+1] + 1;
               count += diff;
               scores[i] -= diff;
           }
       }
       
       System.out.println(count);
   }
}