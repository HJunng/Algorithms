package Silver4;

import java.io.*;
import java.util.*;
public class BJ1269_대칭차집합 {	//9min.
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int A = Integer.parseInt(str[0]);
		int B = Integer.parseInt(str[1]);
		
		Map<Integer, Integer> map = new HashMap<>();
		str = br.readLine().split(" ");
		for(int i=0;i<A;i++)	//map에 넣으면서 기존에 값이 존재하면 value에 +1해줌.
			map.put(Integer.parseInt(str[i]), map.getOrDefault(Integer.parseInt(str[i]), 0)+1);
		
		str=br.readLine().split(" ");
		for(int i=0;i<B;i++)	//위와 같이 해줌.
			map.put(Integer.parseInt(str[i]), map.getOrDefault(Integer.parseInt(str[i]), 0)+1);
		
		int result=0;
		for(int n : map.keySet()) {
			if(map.get(n)==1)	//겹치지 않고 숫자가 하나만 있으면 result++;
				result++;
		}
		System.out.println(result);
	}
}
