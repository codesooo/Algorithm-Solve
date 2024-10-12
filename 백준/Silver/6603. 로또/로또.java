import java.io.*;
import java.util.*;
public class Main {
    private static int r = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            combinations(arr, 0, new ArrayList<>());
            System.out.println();
        }
    }

    private static void combinations(int[] arr, int start, List<Integer> current) {
        if (current.size() == r) {
            for (int num : current) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            combinations(arr, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
