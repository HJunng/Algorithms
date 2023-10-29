import java.math.BigInteger;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
	
		
		// 하노이탑 원판 이동 횟수 : 2^N-1
		BigInteger cnt = new BigInteger("2"); 
		// N이 100인 경우 Long형의 범위를 벗어난다.
		System.out.println(cnt.pow(N).subtract(new BigInteger("1")));
		
		
		if(N<=20) {
			backtracking(1,3,2,N);
			System.out.println(sb);
		}
	}
	static void backtracking(int start, int end, int mid, int n) {
		if(n==1) { // 원판 1개만 옮기는 경우: 1->3 
			sb.append(start+" "+end).append("\n");
		}
		else {
			//N-1개의 원판을 1->2 로 옮김.
			backtracking(start,mid,end,n-1);
			
			// 남은 1개 원판을 1->3 으로 옮김.
			sb.append(start+" "+end).append("\n");
			
			// N-1개의 원판을 다시 2->3으로 옮김. 
			backtracking(mid,end,start,n-1);
		}
	}
}