import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] counts = new int[n];

    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
        stack.pop();
      }
      counts[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
      stack.push(i);
    }
    for (int count : counts) {
      bw.write(count + " ");
    }
    bw.flush();
    bw.close();
  }
}
