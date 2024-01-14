class Solution
{
    public int solution(int n, int a, int b)
    {
		int answer = 1;
		int left = 0;
		int right = 0;
		if (a > b) {
			right = a;
			left = b;
		} else {
			left = a;
			right = b;
		}
		while (n != 0) {
			n /= 2;
			if (left % 2 == 1 && right - left == 1) {	
				break;
			}
			left = (left + 1) / 2;		
			right = (right + 1) / 2;
			answer++;
		}
		return answer;
    }
}