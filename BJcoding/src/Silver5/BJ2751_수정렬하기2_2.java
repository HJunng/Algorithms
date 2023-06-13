package Silver5;

import java.io.*;
import java.util.*;
public class BJ2751_수정렬하기2_2 { //5min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		for(int i :list)
			sb.append(i).append("\n");
		System.out.println(sb);
	}
}