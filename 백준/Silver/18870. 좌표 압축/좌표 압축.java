import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		
		int arr[] = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int arr2[] = arr.clone();
		Arrays.sort(arr2);
		
		int count=0;
		for(int i=0;i<N;i++) {
			if(!map.containsKey(arr2[i]))
				map.put(arr2[i], count++);
		}
		for(int i=0;i<N;i++)
			sb.append(map.get(arr[i])).append(" ");
		System.out.println(sb);
	}
}