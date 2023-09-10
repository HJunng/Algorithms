package Silver3;

import java.io.*;
import java.util.*;

public class BJ2606_바이러스_3 {
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computers = Integer.parseInt(br.readLine());
		int connects = Integer.parseInt(br.readLine());
		
		Map<Integer,Set<Integer>> connect = new HashMap<>();
		for(int i=1;i<=computers;i++) connect.put(i, new HashSet<>());
		
		String[] s;
		for(int i=0;i<connects;i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			connect.get(a).add(b);//컴퓨터 연
			connect.get(b).add(a);
		}
		
		visited = new boolean[computers+1];
		
		System.out.println(dfs(1,0,connect));
	}

	private static int dfs(int now, int cnt, Map<Integer,Set<Integer>> connect) {
		
		visited[now]=true;
		
		for(int next : connect.get(now)) {
			if(!visited[next]) {
				cnt+=dfs(next,cnt,connect);
			}
		}
		
		return cnt;
	}

}
