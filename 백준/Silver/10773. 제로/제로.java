import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int k = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < k; i++) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
          if (!stack.isEmpty()) {
            stack.pop();
          }
      } else {
        stack.push(n);
      }
    }
      
    int sum = 0;
    int size = stack.size();
    for (int i = 0; i < size; i++) {
      sum += stack.pop();
    }
    bw.write("" + sum);
    bw.close();
    br.close();
  }
}