package Silver5;

import java.io.*;

public class BJ1978_소수찾기 {		//10min

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		
		int result=0;
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(str[i]);
			if(n==1) continue;
			if(n==2) result++;		
			for(int j=2;j<n;j++) {	//2를 소수로 인식 못함. 위에 추가.
				if(n%j==0) break;
				if(j==n-1) result++;
			}
		}
		System.out.println(result);
	}

}
