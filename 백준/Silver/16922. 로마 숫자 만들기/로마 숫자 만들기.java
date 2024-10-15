import java.io.*;
import java.util.*;

public class Main {
    private static List<List<String>> result = new ArrayList<>();
    private static int N;
    private static String[] arr = {"I", "V", "X", "L"};
    private static Set<Integer> resultNums = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        combinations(0, new ArrayList<>());

        for(List<String> list : result){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                switch (list.get(i)){
                    case "I" :
                        sum+=1;
                        break;
                    case "V" :
                        sum += 5;
                        break;
                    case "X":
                        sum += 10;
                        break;
                    case "L":
                        sum += 50;
                        break;
                }
            }
            resultNums.add(sum);
        }
        System.out.println(resultNums.size());

    }

    private static void combinations(int start, List<String> current) {
        if (current.size() == N) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            combinations(i, current);
            current.remove(current.size() - 1);
        }
    }
}
