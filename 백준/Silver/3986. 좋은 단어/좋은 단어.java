import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    int count = 0;
    while (N-- > 0) {
      String str = br.readLine();

      Stack<Character> stack = new Stack<>();
      for (char c : str.toCharArray()) {
        if (!stack.isEmpty() && stack.peek() == c) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
      if (stack.isEmpty()){
        count++;
      }
    }

    bw.write(String.valueOf(count));

    br.close();
    bw.flush();
    bw.close();
  }
}
