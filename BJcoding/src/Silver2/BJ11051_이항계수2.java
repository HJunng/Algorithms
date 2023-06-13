package Silver2;

import java.util.*;
public class BJ11051_이항계수2 {	//32min. 답 봄.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		int A[][] = new int[N+1][N+1];
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j || j==0)
					A[i][j]=1;	//nC0 == nCn == 1
				else {
					A[i][j] = (A[i-1][j-1] + A[i-1][j])%10007;	//파스칼 삼각형
				}
			}
		}
		System.out.println(A[N][K]);
	}
}