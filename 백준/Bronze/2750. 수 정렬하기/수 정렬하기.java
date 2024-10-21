import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 입력받은 수를 저장할 배열
        int[] numbers = new int[N];
        
        // N개의 수를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        
        // 배열 정렬
        Arrays.sort(numbers);
        
        // 정렬된 결과 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int number : numbers) {
            bw.write(Integer.toString(number));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}