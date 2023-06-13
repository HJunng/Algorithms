package Silver2;

import java.io.*;
import java.util.*;

public class BJ18870_좌표압축 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		
		int arr[] = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {	//O(n)
			arr[i] = Integer.parseInt(str[i]);
			/*이방법 X -> list.contains도 시간 복잡도가 O(n)이어서 이중for문이랑 같다.
			if(!list.contains(arr[i]))	//똑같이 arraylist에도 저장하는데 중복 없이 저장함.
				list.add(arr[i]);
			*/
		}
		int arr2[] = arr.clone();
		
		Collections.sort(list);
		
		for(int i=0;i<N;i++) {
			sb.append(list.indexOf(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}