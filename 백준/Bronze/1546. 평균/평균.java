import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        int M = 0;
        int scoreSum = 0;
        for (int i=0; i<N; i++){
            score[i] = sc.nextInt();
            scoreSum += score[i];
            M = (M < score[i]) ? score[i] : M;
        }
        System.out.println(scoreSum * 100.0 / M / N);
    }
}
