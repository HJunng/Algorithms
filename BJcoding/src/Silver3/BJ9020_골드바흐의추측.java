package Silver3;

import java.io.*;
import java.util.Arrays;

public class BJ9020_골드바흐의추측 {		//20min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean b[] = new boolean[10001];
		Arrays.fill(b, true);
		b[1]=false;
		for(int i=2;i<=5000;i++) {	//true=소수.
			if(!b[i]) continue;
			for(int j=2;i*j<=10000;j++) {
				b[i*j]=false;
			}
		}
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());
			for(int a=n/2;a>=2;a--) {
				if(!b[a]) continue;	//소수 아니면 다음 소수 찾음.
				else if(!b[n-a]) continue;
				else {
					System.out.println(a+" "+(n-a));
					break;
				}
			}
		}
	}
}
