import java.io.*;
import java.util.*;

public class Main {
	static Map<Integer,ArrayList<Integer>> rel;
	static boolean[] visited;
	static int result = -1;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 사람 수
		
		rel = new HashMap<>();
		for(int i=1;i<=n;i++) rel.put(i, new ArrayList<>());
		
		String[] s = br.readLine().split(" ");
		int person1 = Integer.parseInt(s[0]);
		int person2 = Integer.parseInt(s[1]); 
		
		int m = Integer.parseInt(br.readLine()); // 관계의 개수
		for(int i=0;i<m;i++) {
			s = br.readLine().split(" ");
			
			int parent = Integer.parseInt(s[0]);
			int child = Integer.parseInt(s[1]);
			
			rel.get(parent).add(child);
			rel.get(child).add(parent);
		}
		visited = new boolean[n+1];
		dfs(person1,person2,0);
		
		System.out.println(result);
	}
	static void dfs(int now, int end, int cnt) {
		if(now==end) {
			result=cnt; return;
		}
		
		visited[now]=true;
		
		for(int next : rel.get(now)) {
			if(!visited[next]) {
				dfs(next,end,cnt+1);
			}
		}
	}
}