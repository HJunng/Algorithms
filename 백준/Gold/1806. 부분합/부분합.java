import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		
		s = br.readLine().split(" ");
		int[] sum = new int[N+1];
		for(int i=1;i<=N;i++) {
			sum[i]=Integer.parseInt(s[i-1]) + sum[i-1];
		}
		
		int minLen = Integer.MAX_VALUE; 
		for(int i=0;i<=N;i++) {
			int right=N;
			int left=i;
			if(sum[right]-sum[i]<S) break;
			
			int len=0;
			while(left<=right) {
				int half=(left+right)/2;
				if(sum[half]-sum[i]>=S) {
					len=half-i;
					right=half-1;
				}else {
					left=half+1;
				}
			}
			if(len<minLen)minLen=len;
		}
        if(minLen==Integer.MAX_VALUE) minLen=0;
		System.out.println(minLen);
	}
}