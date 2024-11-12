import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // ArrayList 사용하여 숫자 저장
        ArrayList<Integer> numbers = new ArrayList<>();
        
        // 입력 받기
        for(int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        
        // Collections.sort() 사용 - TimSort 알고리즘 (O(nlogn))
        Collections.sort(numbers);
        
        // 결과 출력
        for(int number : numbers) {
            bw.write(number + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}