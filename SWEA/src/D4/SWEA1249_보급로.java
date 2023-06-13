package D4;

import java.io.*;

public class SWEA1249_보급로 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		
		for(int t=1;t<=tc;t++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] num=new int[N][N];
			
			for(int i=0;i<N;i++) {
				s = br.readLine().split("");
				
				for(int j=0;j<N;j++) {
					num[i][j]=Integer.parseInt(s[j]);
					
					if(i==0 && j!=0) num[i][j]+=num[i][j-1];
					if(i!=0 && j==0) num[i][j]+=num[i-1][j];
					if(i!=0 && j!=0)
						num[i][j]+=Math.min(num[i-1][j], num[i][j-1]);
					System.out.print(num[i][j]);
				}
				System.out.println();
			}
			
			sb.append("#"+t+" "+num[N-1][N-1]+"\n");
		}
		System.out.println(sb);
	}

}
