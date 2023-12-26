import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> line = new ArrayList<>();
	static int N;
	static int[] taller;
	static boolean[] visited;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		taller = new int[N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) taller[i+1]=Integer.parseInt(st.nextToken());
		
		dfs(0);
		
		
	}
	static void dfs(int depth) {
		if(depth==N) {
			if(line.size()==N) {
				for(int i=0;i<N;i++) System.out.print(line.get(i)+ " ");
			}
			return;
		}
		
		// depth 번째에 i를 세운다.
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue; // 이전에 줄 세운사람이면 건너 뜀.
			int left = taller[i]; //i보다 왼쪽에 있는 큰 사람 수.
			
			int cnt=0;
			for(int j=0;j<line.size();j++) {
				if(line.get(j)>i) cnt++;
			}
			
			// i 왼쪽에 left만큼의 사람이 있다면, 줄 세움.
			if(cnt==left) {
				line.add(i);
				visited[i]=true;
				
				dfs(depth+1);
				
				line.remove(line.size()-1);
				visited[i]=false;
			}
		}
	}
}