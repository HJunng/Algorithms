import java.util.*;

public class Main {

	public static void main(String[] args) {
        
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int count=0;
		Set<Integer> set = new HashSet<>();
		set.add(0);
		
		for(int i=0;i<n;i++) {
			
			int x = s.nextInt();
			int y = s.nextInt();
			
			Iterator<Integer> iterator = set.iterator();
			while (iterator.hasNext()) {
			    int j = iterator.next();
			    if (y < j) {
			        iterator.remove();
			    }
			}
			
			if(!set.contains(y)) {
				count++;
				set.add(y);
			}
		}
		
		System.out.println(count);
	}
}