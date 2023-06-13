package D2;

import java.io.*;

public class SWEA1974_스도쿠검증 {
	static boolean[] check;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		String s[];
		
		for(int t=1;t<=tc;t++) {
			int answer=1;
			
			int[][] num = new int[9][9];
			for(int i=0;i<9;i++) {				
				s=br.readLine().split(" ");
				//가로 검증
				check=new boolean[10];
				for(int j=0;j<9;j++) {
					num[i][j]=Integer.parseInt(s[j]);
					
					if(!check[num[i][j]])
						check[num[i][j]]=true;
					else {
						answer=0;
					}
				}
			}
			//세로 검증
			for(int i=0;i<9;i++) {
				if(answer==0) break;
				check=new boolean[10];
				for(int j=0;j<9;j++) {
					if(!check[num[j][i]])
						check[num[j][i]]=true;
					else {
						answer=0;
						break;
					}
				}
			}
			//3*3 검증
			for(int a=0;a<3;a++) {
				if(answer==0) break;
				for(int b=0;b<3;b++) {
					if(answer==0) break;
					
					check=new boolean[10];
					for(int i=0;i<3;i++) {
						if(answer==0) break;
						
						for(int j=0;j<3;j++) {
							if(!check[num[a*3+i][b*3+j]])
								check[num[a*3+i][b*3+j]]=true;
							else {
								answer=0;
								break;
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+answer);
			//sb.append("#"+t+" "+answer+"\n");
		}
		//System.out.println(sb);
	}
}