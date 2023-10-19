import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int N = s.nextInt(); // 접시 수 
		int d = s.nextInt(); // 초밥의 가짓수 
		int k = s.nextInt(); // 연속 접시 수
		int c = s.nextInt(); // 쿠폰 번호
		
		// 회전벨트이기 때문에, 주어진 초밥 번호를 다 넣고 뒤에 연속될 수 있는 초밥까지 더 넣기.
		// 주어진 벨트 : 7 9 7 30 2 7 9 25
		// -> 추가된 벨트 : 7 9 7 30 2 7 9 25 (7 9 7) -> k-1 개 앞에 초밥 추가.
		int[] round = new int[N+k-1]; 
		int cnt=0;
		for(;cnt<N;cnt++) round[cnt] = s.nextInt();
		for(int i=0;i<k-1;i++) round[cnt++] = round[i];
		
		//System.out.println(Arrays.toString(round));
		
		int left=0; // 뺄 초밥
		int right=k; // 추가할 초밥 
		Map<Integer,Integer> cntMap = new HashMap<>();
		cntMap.put(c,1); // 쿠폰 초밥 넣어놓기.
		for(int i=left;i<right;i++) 
			cntMap.put(round[i],cntMap.getOrDefault(round[i], 0)+1);
		
		int maxKinds = cntMap.size(); // 처음 연속된 k개의 종류 개수.
		
		while(right<round.length) {
			// 1. left 초밥 빼기
			if(cntMap.get(round[left])==1) { // left 초밥이 1개면 그냥 없앰.
				cntMap.remove(round[left]);
			}else { // 2개 이상 있다면 갯수만 1개 빼줌. 
				cntMap.put(round[left], cntMap.get(round[left])-1);
			}
			
			// 2. right 초밥 추가
			// 없으면 그냥 갯수1개로 추가, 있던 초밥이면 갯수 추가.
			cntMap.put(round[right], cntMap.getOrDefault(round[right], 0)+1);
			
			// 3. left 초밥은 빼고, Right 초밥을 추가한 상태에서의 가짓수가 max인지 갱신.
			maxKinds = Math.max(maxKinds, cntMap.size());
			
			if(maxKinds==k+1) break;
			
			left++; right++; // 투 포인터 오른쪽으로 옮기
		}
		
		System.out.println(maxKinds);
	}
}