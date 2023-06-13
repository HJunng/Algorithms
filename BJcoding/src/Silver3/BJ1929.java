package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1929 {	//50min

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int M = s.nextInt();
		int N = s.nextInt();
		
		boolean b[] = new boolean[N+1];
		Arrays.fill(b, true);
		b[1]=false;
		
		for(int i=2;i<=N/2;i++) {
			if(!b[i]) continue;
			for(int j=2;i*j<=N;j++) {
				b[i*j]=false;
			}
		}
		for(int i=M;i<=N;i++) {
			if(b[i]) System.out.println(i);
		}
	}

}
