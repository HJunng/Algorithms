package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1244 {
	static String num;
	static PriorityQueue<String> pq;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		String[] s;
		
		for(int t=1;t<=tc;t++) {
			s = br.readLine().split(" ");
			
			num = s[0];
			int cnt=Integer.parseInt(s[1]);
			
			pq  = new PriorityQueue<>();
			pq.add(num);
			dfs(cnt);
			
			//System.out.println(pq);
			System.out.println("#"+t+" "+pq.poll());
		}
	}

	private static void dfs(int cnt) {
		if(cnt==0) return;
		//System.out.println(pq);
		Set<String> set = new HashSet<>();
		
		while(pq.size()>0) {
			String s = pq.poll();
			System.out.println(s);
			char[] c = s.toCharArray();
			
			for(int i=0;i<c.length;i++) {
				for(int j=i+1;j<c.length;j++) {
					char temp = c[i];
					c[i]=c[j];
					c[j]=temp;
					System.out.println(i+" "+j+" "+c.toString());
					
					set.add(c.toString());
					System.out.println("set: "+set);
				}
			}
		}
		for(String s : set)
			pq.add(s);
		
		//System.out.println(pq);
		
		dfs(cnt-1);
	}
}