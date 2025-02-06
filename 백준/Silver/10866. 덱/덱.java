import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> d = new ArrayDeque<>();
		String str[];
		
		for(int i=0;i<n;i++) {
			str = br.readLine().split(" ");
			
			switch(str[0]) {
			case("push_front"):{
				d.addFirst(Integer.parseInt(str[1]));
				break;
			}
			case("push_back"):{
				d.addLast(Integer.parseInt(str[1]));
				break;
			}
			case("pop_front"):{
				if(d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.pollFirst()).append("\n");
				break;
			}
			case("pop_back"):{
				if(d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.pollLast()).append("\n");
				break;
			}
			case("size"):{
				sb.append(d.size()).append("\n");
				break;
			}
			case("empty"):{
				if(d.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
			}
			case("front"):{
				if(d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.peekFirst()).append("\n");
				break;
			}
			case("back"):{
				if(d.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(d.peekLast()).append("\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}
}