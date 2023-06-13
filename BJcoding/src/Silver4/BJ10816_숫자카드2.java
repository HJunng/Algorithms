package Silver4;

import java.io.*;
import java.util.*;

public class BJ10816_숫자카드2 {	//10min.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		String str[] = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(str[i]);
			map.put(temp, map.getOrDefault(temp, 0)+1);
			//기존에 해당 값이 없었으면 0에 +1,있으면 있던 값에 +1
		}
		int M = Integer.parseInt(br.readLine());
		str = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(str[i]);
			if(map.containsKey(tmp))
				sb.append(map.get(tmp)).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb);
	}

}
