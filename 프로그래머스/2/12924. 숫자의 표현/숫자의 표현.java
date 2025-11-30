class Solution {
    public int solution(int n) {
        int cnt = 0;
        int temp = 0;
        for(int a=1; a<=n; a++){
            temp = canN(a, n);
            if (temp == n) {
                cnt++;
            }
        }
        return cnt;
    }
    private static int canN(int a, int n){
        int num = a;
        while (num < n){
            a++;
            num += a;
        }
        return num;
    }
}