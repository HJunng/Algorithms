package Bronze1;

import java.io.*;
import java.util.*;

public class BJ10989_수정렬하기3 {		//13min

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		
		for(int i=0;i<N;i++)
			a[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(a);
		
		for(int i : a)
			sb.append(i).append("\n");
		System.out.println(sb);
	}
}
