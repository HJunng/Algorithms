package D2;

import java.io.*;

public class SWEA1940_가랏rc카 { //15min.

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			int n=Integer.parseInt(br.readLine());
			
			int sum=0;//거리
			int speed=0;//속도
			
			for(int i=0;i<n;i++) {
				String[] s = br.readLine().split(" ");
				
				int command = Integer.parseInt(s[0]);
				
				//속도 유지
				if(command==0)
					sum+=speed;
				//가속
				else if(command==1) {
					speed += Integer.parseInt(s[1]);
					sum+=speed;
				//감속
				}else if(command==2) {
					if(speed<Integer.parseInt(s[1]))
						speed=0;
					else
						speed-=Integer.parseInt(s[1]);
					sum+=speed;
				}
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb);
	}
}
