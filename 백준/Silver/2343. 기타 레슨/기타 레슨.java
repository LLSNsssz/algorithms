import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] lectures = new int[N];
		st = new StringTokenizer(br.readLine());

		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			right += lectures[i];
			left = Math.max(left, lectures[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			int count = 1;

			for (int lecture : lectures) {
				if (sum + lecture > mid) {
					count++;
					sum = lecture;
				} else {
					sum += lecture;
				}
			}

			if (count <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(left);
	}
}

