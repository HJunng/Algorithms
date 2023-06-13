package Gold4;

import java.io.*;
import java.util.Arrays;
public class BJ2981_검문 {	//90min. 답 봄.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int A[] = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(A);
		
		int maxM = A[1]-A[0];
		
		for(int i=2;i<N;i++) {
			maxM = gcd(maxM,A[i]-A[i-1]);
		}
		
		for(int i=2;i<=maxM;i++) {
			if(maxM%i==0)
				sb.append(i).append(" ");
		}
		System.out.println(sb);
		/*  73% 시간 초과
		for(int j=2;j<=A[1];j++) {//두번째 수까지 M이 나올 수 있음.
			int rest = A[0]%j;//제일 앞의 수를 j로 나눈 나머지 넣기.
			for(int i=1;i<N;i++) {//나머지 같은지 검사
				if(A[i]%j != rest)//나머지가 같지 않으면 바로 break;
					break;
				if(i==N-1)//끝까지 오면 출력.
					sb.append(j).append(" ");
			}
		}
		*/
	}
	private static int gcd(int a, int b) {//최대공약수.
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
		}
		return a;
	}
}