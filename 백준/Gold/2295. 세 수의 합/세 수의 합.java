import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        List<Integer> twoSum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                twoSum.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(twoSum);
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (binarySearch(twoSum, arr[i] - arr[j])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
    
    private static boolean binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) {
                return true;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}