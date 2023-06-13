package ssafy1;

import java.io.*;

public class ssafy01 { 

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=tc;t++) {
			
			int N = Integer.parseInt(br.readLine());
			String []s = br.readLine().split(" ");
			
			int[] people = new int[N];
			for(int i=0;i<N;i++) {
				people[i]=Integer.parseInt(s[i]);
			}
			
			int cnt=0;
			boolean[] visited = new boolean[N];
			
			for(int i=0;i<N;i++) {
				//이미 짝 지어졌으면 통과
				if(visited[i]) continue;
				
				int a = i;
				int b = i+people[i]; // i번째 사람이 고른 사람
				if(b<0 || b>=N) continue;
				int c = people[b]+b;
				if(c<0 || c>=N) continue;
				
				if(a==c) {
					cnt++;
					//System.out.println(cnt+": "+a+" "+b);
					visited[a]=true;
					visited[b]=true;
				}
				
			}
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}