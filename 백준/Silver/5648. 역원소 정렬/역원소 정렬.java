import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Long> numbers = new ArrayList<>();

    int n = scanner.nextInt(); // 첫 번째 숫자는 입력할 원소의 개수

    for (int i = 0; i < n; i++) {
      String numStr = scanner.next();
      String reversedStr = new StringBuilder(numStr).reverse().toString();
      long reversedNum = Long.parseLong(reversedStr);
      numbers.add(reversedNum);
    }

    Collections.sort(numbers);

    for (long num : numbers) {
      System.out.println(num);
    }

    scanner.close();
  }
}
