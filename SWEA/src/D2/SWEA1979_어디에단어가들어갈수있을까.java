package D2;

import java.io.*;

public class SWEA1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]); //가로 세로 길이
			int K = Integer.parseInt(s[1]); //단어 길이
			
			int[][] box = new int[N][N];
			int answer=0;

			//가로로 K길이의 빈칸이 있는지 확인.
			for(int i=0;i<N;i++) {
				s = br.readLine().split(" ");
				int cnt=0;
				
				for(int j=0;j<N;j++) {
					box[i][j]=Integer.parseInt(s[j]);
					
					if(box[i][j]==0) {
						if(cnt==K) answer++;
						cnt=0;
					}else {
						cnt+=1;
					}
				}
				if(cnt==K) answer++;
			}
			
			//세로 확인
			for(int i=0;i<N;i++) {
				int cnt=0;
				
				for(int j=0;j<N;j++) {
					if(box[j][i]==0) {
						if(cnt==K) answer++;
						cnt=0;
					}else
						cnt++;
				}
				if(cnt==K) answer++;
			}
			
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}