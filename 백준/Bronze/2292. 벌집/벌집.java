import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 1; // 지나가는 방의 개수
        int range = 1; // 현재 범위의 최댓값
        int multiple = 6; // 증가하는 방의 개수 (6의 배수)
        
        while(range < N) {
            range += multiple;
            multiple += 6;
            count++;
        }
        
        System.out.println(count);
    }
}