import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] octalToBinary = {"000", "001", "010", "011", "100", "101", "110", "111"};
        // 구현
        StringBuilder sb = new StringBuilder();
        int num_1 = s.charAt(0) - '0';
        sb.append(Integer.toBinaryString(num_1));
        for (int i = 1; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            sb.append(octalToBinary[num]);
        }
        System.out.println(sb.toString());

    }
}
