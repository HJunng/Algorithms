package Silver2;

import java.io.*;
import java.util.*;

public class BJ4948 {	//55min
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean b[] = new boolean[246913];
		Arrays.fill(b, true);
		b[1]=false;
		int result;
		
		int a=1;
		while(a++<=123456) {
			if(!b[a]) continue;
			for(int i=2;i*a<=246912;i++) {
				b[i*a]=false;
			}
		}
		while(n!=0) {
			result=0;
			for(int i=n+1;i<=2*n;i++) {
				if(b[i]) result++;
			}
			System.out.println(result);
			n=Integer.parseInt(br.readLine());
		}
	}
}
