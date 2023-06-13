package Silver4;

import java.io.*;
import java.util.*;
public class BJ10816_숫자카드2_2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		String s[] = br.readLine().split(" ");
		for(int i=0;i<N;i++)
			map.put(s[i], map.getOrDefault(s[i], 0)+1);
		
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		for(int i=0;i<M;i++) 
			sb.append(map.getOrDefault(s[i], 0)).append(" ");
		
		System.out.println(sb);
	}
}