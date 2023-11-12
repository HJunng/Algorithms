import java.io.*;
public class Main {
	public static boolean A[][];
	public static int N;
	
	public static void star(int n) {//별찍기
		if(n==1) return;
		
		int k=n/3;
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {//역삼각형 위쪽만 계산하면 x,y 바꾼 수 또한 같이 공백이기 때문.
				if((i%n >= k) && (i%n < 2*k) && (j%n >= k) && (j%n< 2*k)) {
					//System.out.println(i+" "+j);
					A[i][j]=true;
					A[j][i]=true;
				}
			}
		}	
		star(k);
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new boolean[N][N];		//다 false로 되어 있음 false=*
		
		star(N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(A[i][j]) sb.append(" ");
				else sb.append("*");
			}
			sb.append("\n");
		}	
		System.out.println(sb);
	}
}