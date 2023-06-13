package Silver4;

import java.io.*;
import java.util.*;
public class BJ1764_듣보잡 {	//15min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {	//듣도 못한 사람들 set에 넣기.
			set.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<M;i++) {//보도 못한 사람들은 arraylist에 넣어서 사전순 배열.
			list.add(br.readLine());
		}
		Collections.sort(list);
		
		int result=0;
		for(String s : list) {//사전순으로 된 리스트를 가져와 하나씩 검사하여 StringBuilder에 넣기.
			if(set.contains(s)) {
				result++;
				sb.append(s).append("\n");
			}
		}
		System.out.println(result);
		System.out.println(sb);
	}
}