import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int num : arr) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);

    }
}
