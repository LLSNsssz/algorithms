import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int count = Integer.parseInt(br.readLine());
    Queue<Integer> queue = new LinkedList<>();
    int lastElement = -1;

    for (int i = 0; i < count; i++) {
      String[] command = br.readLine().split(" ");
      switch (command[0]) {
        case "push":
          int value = Integer.parseInt(command[1]);
          queue.offer(value);
          lastElement = value;
          break;
        case "pop":
          if (queue.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(String.valueOf(queue.poll()) + "\n");
          }
          break;
        case "size":
          bw.write(String.valueOf(queue.size()) + "\n");
          break;
        case "empty":
          bw.write(queue.isEmpty() ? "1\n" : "0\n");
          break;
        case "front":
          bw.write(queue.isEmpty() ? "-1\n" : String.valueOf(queue.peek()) + "\n");
          break;
        case "back":
          bw.write(queue.isEmpty() ? "-1\n" : String.valueOf(lastElement) + "\n");
          break;
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
