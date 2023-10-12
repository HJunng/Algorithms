import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		Map<Integer,List<Integer>> win = new HashMap<>();
		for(int i=1;i<=N;i++) win.put(i, new ArrayList<Integer>());
		
		int[] weight = new int[N+1];
		
		for(int i=0;i<M;i++) {
			s = br.readLine().split(" ");
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			
			win.get(a).add(b);
			weight[b]++;
		}
		
		TopologicalSort(win,weight);
	}
	static void TopologicalSort(Map<Integer,List<Integer>> list, int[] w) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int start: list.keySet()) {
			if(w[start]==0) {
				q.add(start);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			
			for(int connect : list.get(now)) {
				w[connect]--;
				
				if(w[connect]==0) {
					q.add(connect);
				}
			}
		}
	}
}