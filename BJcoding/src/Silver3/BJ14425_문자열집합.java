package Silver3;

import java.io.*;
import java.util.*;

public class BJ14425_문자열집합 {	//5min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[]= br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++)
			set.add(br.readLine());
		
		int result=0;
		for(int i=0;i<M;i++) {
			String s = br.readLine();
			if(set.contains(s))		//포함하는지 확인.
				result++;
		}
		System.out.println(result);
	}
}