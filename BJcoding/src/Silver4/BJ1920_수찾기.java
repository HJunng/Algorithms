package Silver4;

import java.io.*;
import java.util.*;

public class BJ1920_수찾기 { // 10min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		Map<String,Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		
		String s[] = br.readLine().split(" ");
		for(int i=0;i<N;i++)
			set.add(s[i]);
		
		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			if(set.contains(s[i]))
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
	}
}