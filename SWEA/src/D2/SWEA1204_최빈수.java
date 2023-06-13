package D2;

import java.io.*;
import java.util.*;
public class SWEA1204_최빈수 {
	static Map<Integer,Integer> map;
	static List<Integer> keys;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0;t<tc;t++) {
			int num=Integer.parseInt(br.readLine());
			
			map = new HashMap<>();
			
			String[] s = br.readLine().split(" ");
			
			int max=0;
			int maxKey=0;
			for(int i=0;i<s.length;i++) {
				int x = Integer.parseInt(s[i]);
				
				map.put(x, map.getOrDefault(x, 0)+1);
				if(map.get(x)>max) {
					max=map.get(x);
					maxKey=x;
				}else if(map.get(x)==max) {
					if(x > maxKey)
						maxKey=x;
				}
			}
			System.out.println("#"+num+" "+maxKey);
		}
	}
}