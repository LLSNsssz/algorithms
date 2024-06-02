import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String k = br.readLine();
    int count = Integer.parseInt(br.readLine());

    List<String> stringList = new LinkedList<>(Arrays.asList(k.split("")));

    ListIterator<String> iterator = stringList.listIterator();
    while (iterator.hasNext()) {
      iterator.next(); // 커서를 문장의 맨 뒤로 이동
    }

    for (int i = 0; i < count; i++) {
      String command = br.readLine();
      char cmd = command.charAt(0);

      switch (cmd) {
        case 'L':
          if (iterator.hasPrevious()) {
            iterator.previous();
          }
          break;

        case 'D':
          if (iterator.hasNext()) {
            iterator.next();
          }
          break;

        case 'B':
          if (iterator.hasPrevious()){
            iterator.previous();
            iterator.remove();
          }
          break;

        case 'P':
          String str = "" + command.charAt(2);
          iterator.add(str);
          break;

      }
    }

    StringBuilder sb = new StringBuilder();
    for (String s : stringList) {
      sb.append(s);
    }
      
    System.out.println(sb.toString());

    br.close();
  }
}
