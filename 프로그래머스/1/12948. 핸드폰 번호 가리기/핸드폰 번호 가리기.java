class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int n = phone_number.length();
        String last = phone_number.substring(n-4,n);
        answer = "*".repeat(n-4).concat(last);
        return answer;
    }
}