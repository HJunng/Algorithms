package Silver1;

import java.util.Scanner;

public class BJ12852_1로만들기2 {
	static int[][] cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		cnt = new int[n+1][2]; // [0]에는 연산최소 횟수, [1]:이전 숫자
		
		dp(n);
		System.out.println(cnt[n][0]);
		
		//n부터 이전 숫자를 하나씩 탐색하며 출력한다.
		System.out.print(n+" ");
		while(n>1) {
			System.out.print(cnt[n][1]+" ");
			n=cnt[n][1];
		}
	}
	static private void dp(int n) {
		
		cnt[1][0]=0;
		for(int i=2;i<=n;i++) {
			cnt[i][0]=cnt[i-1][0]+1; // 1뺀거에서 넘어옴.
			cnt[i][1] = i-1; //이전 숫자
			
			if(i%2==0 && cnt[i/2][0]+1<cnt[i][0]) {
				cnt[i][0]=cnt[i/2][0]+1;
				cnt[i][1]=i/2;
			}
			if(i%3==0 && cnt[i/3][0]+1<cnt[i][0]) {
				cnt[i][0]=cnt[i/3][0]+1;
				cnt[i][1]=i/3;
			}
		}
	}
}
