import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Deque<Integer> stack = new ArrayDeque<>();

    int[] arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder result = new StringBuilder();
    int current = 1;
    boolean possible = true;

    for (int i = 1; i <= n; i++) {
      while (current <= arr[i]) {
        stack.push(current++);
        result.append("+\n");
      }

      if (stack.isEmpty() || stack.peek() != arr[i]) {
        possible = false;
        break;
      }

      stack.pop();
      result.append("-\n");
    }

    if (possible) {
      bw.write(result.toString());
    } else {
      bw.write("NO\n");
    }

    bw.flush();
    bw.close();
  }
}