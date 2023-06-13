package Silver2;

import java.io.*;

public class BJ14889_스타트와링크 {		//30min. 답. shit.
	public static int stat[][];
	public static int min = Integer.MAX_VALUE;//스탯 차.
	public static int N;
	public static boolean[] visit;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		visit = new boolean[N];
		String str[];
		for(int i=0;i<N;i++) {	//능력치 입력받기.
			str = br.readLine().split(" ");
			for(int j=0;j<N;j++)
				stat[i][j] = Integer.parseInt(str[j]);
		}
		
		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int num, int depth) {//A팀 스탯, B팀 스탯, 깊이
		if(depth==N/2) {
			diff();
			return;
		}
		for(int i=num;i<N;i++) {
			if(!visit[i]) {
				visit[i]=true;
				dfs(i+1,depth+1);
				visit[i]=false;
			}
		}
		
	}
	private static void diff() {
		int start=0;
		int link=0;
		for(int i=0;i<N-1;i++) {
			for(int j=i;j<N;j++) {
				if (visit[i] == true && visit[j] == true) {
					start += stat[i][j];
	                start += stat[j][i];
	            } else if (visit[i] == false && visit[j] == false) {
	            	link += stat[i][j];
	                link += stat[j][i];
	            }
			}
		}
		int val=Math.abs(start-link);
		min = Math.min(val, min);
	}

}
