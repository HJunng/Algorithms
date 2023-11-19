import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int K = s.nextInt();
		
		int A[][] = new int[N+1][N+1];
		
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<=i;j++) {
				if(i==j || j==0)
					A[i][j]=1;
				else {
					A[i][j] = (A[i-1][j-1] + A[i-1][j])%10007;
				}
			}
		}
		System.out.println(A[N][K]);
	}
}