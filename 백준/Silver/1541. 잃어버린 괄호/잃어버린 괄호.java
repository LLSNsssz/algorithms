import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minusSplit = br.readLine().split("-");
        
        int answer = 0;
        
        // 첫 번째 그룹은 더하기
        String[] plus = minusSplit[0].split("\\+");
        for(String num : plus) {
            answer += Integer.parseInt(num);
        }
        
        // 나머지 그룹은 빼기
        for(int i = 1; i < minusSplit.length; i++) {
            int sum = 0;
            String[] nums = minusSplit[i].split("\\+");
            for(String num : nums) {
                sum += Integer.parseInt(num);
            }
            answer -= sum;
        }
        
        System.out.println(answer);
    }
}