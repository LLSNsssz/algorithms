import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine()); // 케이스 개수

    while (T-- > 0) {
      String AC = br.readLine(); // 수행할 연산들
      int count = Integer.parseInt(br.readLine()); // 배열에 들어있는 수의 개수
      String arrString = br.readLine(); // 배열을 나타내는 문자열
      String[] split = arrString.substring(1, arrString.length() - 1).split(","); // []떼고 ","를 기준으로 split
      Deque<Integer> deque = new ArrayDeque<>(); // 입력받은 정수들을 저장할 데크
      boolean isReverse = false; // 배열이 뒤집어졌는지 체크
      boolean isEmpty = false; // 에러 발생여부 체크

      for (int i = 0; i < count; i++) {
        deque.add(Integer.valueOf(split[i]));
      }

      for (int i = 0; i < AC.length(); i++) {
        if (AC.charAt(i) == 'R') {
          isReverse = !isReverse;
        } else {
          if (deque.isEmpty()) {
            isEmpty = true;
          }
          if (isReverse) {
            if (!isEmpty) deque.removeLast();
          } else {
            if (!isEmpty) deque.removeFirst();
          }
        }
      }

      if (isEmpty) {
        bw.write("error\n");
      } else {
        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
          sb.append(isReverse ? deque.removeLast() : deque.removeFirst());
          if (!deque.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
        bw.write(String.valueOf(sb));
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
