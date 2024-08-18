import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    String arrangement = br.readLine();

    int result = countMaxPeopleEating(N, K, arrangement);
    System.out.println(result);
  }
  
    public static int countMaxPeopleEating(int N, int K, String arrangement) {
      int peopleEating = 0;
      ArrayList<Integer> hamburgers = new ArrayList<>();

      // 햄버거 위치 저장
      for (int i = 0; i < N; i++) {
        if (arrangement.charAt(i) == 'H') {
          hamburgers.add(i);
        }
      }

      // 각 사람에 대해 가장 가까운 햄버거 찾기
      for (int i = 0; i < N; i++) {
        if (arrangement.charAt(i) == 'P') {
          for (int j = 0; j < hamburgers.size(); j++) {
            if (Math.abs(i - hamburgers.get(j)) <= K) {
              peopleEating++;
              hamburgers.remove(j);
              break;
            }
          }
        }
      }

      return peopleEating;
    }

  
  }