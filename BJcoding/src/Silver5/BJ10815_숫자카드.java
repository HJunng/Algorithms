package Silver5;

import java.io.*;
import java.util.*;

public class BJ10815_숫자카드 {	//12min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		//ArrayList<Integer> list = new ArrayList<>();		//ArrayList로 구현했다가 시간 초과 남.
		Set<Integer> set = new HashSet<>();		
		
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++)	//집합에 가지고 있는 카드 숫자 다 넣음.
			set.add(Integer.parseInt(str[i]));
		
		int M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			int temp = Integer.parseInt(str[i]);
			if(set.contains(temp))	//가지고 있는 숫자 카드인지 검사.
				sb.append(1).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}
}