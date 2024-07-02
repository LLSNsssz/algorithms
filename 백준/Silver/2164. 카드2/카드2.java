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
    br.close();

    Deque<Integer> queue = new ArrayDeque<>();
    for(int i = 1; i <= n; i++) {
      queue.offer(i);
    }
    while (queue.size() != 1){
      queue.pollFirst();
      queue.offerLast(queue.pollFirst());
    }
    bw.write(String.valueOf(queue.peek()));

    bw.flush();
    bw.close();
  }
}
