import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(st1.nextToken());
    int m = Integer.parseInt(st1.nextToken());
    Deque<Integer> leftDeque = new ArrayDeque<>();
    Deque<Integer> rightDeque = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      leftDeque.offer(i);
      rightDeque.offer(i);
    }

    int leftCount = 0;
    int rightCount = 0;
    int totalCount = 0;
    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st2.nextToken());

      while(target != rightDeque.getFirst()) {
        rightDeque.addFirst(rightDeque.removeLast()); // 오른쪽으로 한칸
        rightCount++;
      }
      while (target != leftDeque.getFirst()) {
        leftDeque.addLast(leftDeque.removeFirst()); // 왼쪽으로 한칸
        leftCount++;
      }
      totalCount += Math.min(leftCount, rightCount);
      leftCount = 0;
      rightCount = 0;

      if (leftCount>rightCount){
        rightDeque.removeFirst();
        leftDeque = new ArrayDeque<>(rightDeque);
      } else{
        leftDeque.removeFirst();
        rightDeque = new ArrayDeque<>(leftDeque);
      }

    }

    bw.write(String.valueOf(totalCount));

    bw.flush();
    bw.close();
  }
}
