import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a.compareTo(b));
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		for(int i=0;i<k-1;i++){
			pq.poll();
		}

		System.out.println(pq.poll());
	}
}