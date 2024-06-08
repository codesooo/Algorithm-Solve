import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String num1 = st.nextToken();
            String num2 = st.nextToken();

            BigInteger binary1 = new BigInteger(num1, 2);
            BigInteger binary2 = new BigInteger(num2, 2);

            BigInteger answer = binary1.add(binary2);
            System.out.println(answer.toString(2));


        }

    }
}
