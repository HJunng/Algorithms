package Silver4;

import java.util.*;
public class BJ2164_카드2 { // 5min.
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) // queue에 1~n까지 넣기.
			q.add(i);
		
		while(q.size()!=1) {
			q.poll(); // 제일 위에 있는 카드를 바닥에 버린다.
			
			int rePush = q.poll(); // 그다음 위에 있는 카드를 제일 아래에 넣는다.
			q.add(rePush);
		}
		System.out.println(q.poll());
	}
}