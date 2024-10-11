import java.io.*;
import java.util.*;
public class Main {
    private static int[] switchArr;
    public static void main(String[] args) throws IOException {
        // 1. 입력받기
        input();

        // 3. 출력
        for (int i = 1; i < switchArr.length; i++) {
            System.out.print(switchArr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }

    }

    private static void changeStatus(int num){
        if (switchArr[num] == 0) {
            switchArr[num] = 1;
            return;
        }
        switchArr[num] = 0;
    }

    private static void boy(int num) {
        for (int i = 1; i < switchArr.length; i++) {
            if (i % num == 0) {
                changeStatus(i);
            }
        }
    }

    private static void girl(int num) {
        changeStatus(num);

        for (int i = 1; i < num; i++) {
            if (num - i < 1 || num + i >= switchArr.length) {
                break;
            }

            if ((switchArr[num - i]) == (switchArr[num + i])) {
                changeStatus(num - i);
                changeStatus(num + i);
            } else {
                break;
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int switchNum = Integer.parseInt(st.nextToken());

        switchArr = new int[switchNum + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < switchArr.length; i++) {
            switchArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int studentNum = Integer.parseInt(st.nextToken());

        while (studentNum-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            // 2. 구현
            switch(gender) {
                case 1:
                    boy(num);
                    break;
                case 2:
                    girl(num);
                    break;
            }
        }
    }
}
