package D3;

import java.io.*;
import java.util.*;

public class SWEA1208_Flatten {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 1; t++) {
			int cnt = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");

			//오름차순 정렬.
			PriorityQueue<Integer> up = new PriorityQueue<>();
			//내림차순 정렬.
			PriorityQueue<Integer> down = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < s.length; i++) {
				up.add(Integer.parseInt(s[i]));
				down.add(Integer.parseInt(s[i]));
			}
			//System.out.println(up.peek());

			while (cnt > 0) {
				Integer max = down.poll();
				up.remove(max);
				Integer min = up.poll();
				down.remove(min);

				if (max - min <= 1)
					break;

				
				up.add(min+1);
				up.add(max-1);
				down.add(min+1);
				down.add(max-1);
				cnt--;
				//System.out.println(down.peek()+" "+up.peek());
			}

			sb.append("#" + t + " " + (down.peek() - up.peek()) + "\n");
		}
		System.out.println(sb);
	}
}