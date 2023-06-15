package CT;
import java.util.*;
public class CT1_함수구현 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		solution(new int[] {1,2,3,3,3,3,4,4});
		solution(new int[] {3,2,4,4,2,5,2,5,5});
		solution(new int[] {3,5,7,9,1});
		
		
		
	}
	static int[] solution(int[] arr) {
		int answer[] = {};
		
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		
		//중복있는 것들만 list에 넣기.
		List<Integer> answerList = new ArrayList<>();
		for(int i:map.keySet()) {
			if(map.get(i)>1)
				answerList.add(map.get(i));
		}
		if(answerList.isEmpty()) { //중복된 것이 없으면 -1만 배열에 넣어서 출력.
			answer = new int[1];
			answer[0]=-1;
			System.out.println("[-1]");
		}
		else { 
			//list를 배열 형태로 만들기.
			answer = new int[answerList.size()];
			//answer = answerList.stream().mapToInt(Integer::intValue).toArray();
			
			for(int i=0;i<answer.length;i++)
				answer[i]=answerList.get(i);
			
			System.out.println(answerList);
		}
		return answer;
	}
	
}
