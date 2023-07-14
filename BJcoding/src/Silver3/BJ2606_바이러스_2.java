package Silver3;

import java.io.*;
import java.util.*;

public class BJ2606_바이러스_2 {
	static Map<Integer,ArrayList<Integer>> map = new HashMap<>();
	static int virus=0;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com=Integer.parseInt(br.readLine());
		int node = Integer.parseInt(br.readLine());
		
		for(int i=0;i<com;i++) map.put(i+1, new ArrayList<>());
		
		String[] s;
		for(int i=0;i<node;i++) {
			s=br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		visited = new boolean[com+1];
		dfs(1);
		
		System.out.println(virus-1);//1번을 제외해야 하기 때문에 -1해줌.
	}
	static void dfs(int now) {
		
		//System.out.println(now);
		visited[now]=true;
		virus++;
		
		for(int i:map.get(now)) {
			if(!visited[i])
				dfs(i);
		}
	}
}
