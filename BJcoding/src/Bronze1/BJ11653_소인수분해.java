package Bronze1;

import java.io.*;

public class BJ11653_소인수분해 {	//9min

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) return;
		for(int i=2;i<=N;i++) {
			if(N==1) break;	//나누다가 N이 1이되면 for문 나가기.
			
			while(N%i==0) {	//N이 i로 나눠떨어지면 계속 나누기
				System.out.println(i);
				N/=i;
			}
		}
	}
}
