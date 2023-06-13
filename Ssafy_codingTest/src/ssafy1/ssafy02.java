package ssafy1;

import java.io.*;

public class ssafy02 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		String[] s;
		
		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			
			int N = Integer.parseInt(s[0]);
			int D = Integer.parseInt(s[1]);
			
			int[] slow = new int[D+1];
			
			for(int i=0;i<N;i++) {
				s = br.readLine().split(" ");
				
				slow[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
			}
			
			int start=0;
			int end=D;
			int seconds=0;
			
			while(start!=end) {
				
				if(slow[start]>0) {
					slow[start]--;
				}else {
					start++;
				}
				
				if(slow[end]>0) {
					slow[end]--;
				}else {
					end--;
				}
				
				seconds++;
				System.out.println(seconds+": "+start+" "+end);
			}
			
			sb.append("#"+t+" "+start+"\n");
		}
		System.out.println(sb);
	}
}