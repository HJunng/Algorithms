package Silver2;

import java.io.*;
import java.util.*;

public class BJ18870_좌표압축_정답 {	//45min.

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		
		int arr[] = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {	//O(n)
			arr[i] = Integer.parseInt(str[i]);
		}
		int arr2[] = arr.clone();
		Arrays.sort(arr2);		//평균 : O(nlog(n))  최악 : O(n^2)
		
		int count=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(arr2[i]))	//O(1)
				map.put(arr2[i], count++);
		}
		for(int i=0;i<N;i++)
			sb.append(map.get(arr[i])).append(" ");	//map.get O(1)
		System.out.println(sb);
	}
}