import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]); //멀티탭 구멍 개수. 
		int k = Integer.parseInt(s[1]); //전기용품 사용 개수. 
		
		s = br.readLine().split(" ");
		int[] use = new int[k];
		Map<Integer,Integer> remain = new HashMap<>();
		Map<Integer,Integer> dist = new HashMap<>();
		for(int i=0;i<k;i++) {
			use[i]=Integer.parseInt(s[i]);
			remain.put(use[i], remain.getOrDefault(use[i],0)+1);
			if(!dist.containsKey(use[i])) dist.put(use[i], i); //가장 가까운 위치 저장. 
		}
		
		int answer=0; //플러그 바꾼 횟수. 
		ArrayList<Integer> multitap = new ArrayList<>(); // 멀티탭에 꽃혀있는 플러그.
		
		for(int i=0;i<use.length;i++) {
			dist.put(use[i], calDist(use[i],i,use)); //현재 콘센트를 사용했으니, 그 뒤에 같은 콘센트를 사용하는 위치 갱신.
			
			if(multitap.contains(use[i])) continue; //이미 꽃혀있다면 바꿀필요없음. 
			if(multitap.size()<n) {
				multitap.add(use[i]); //아직 콘센트가 다 꽃혀있지 않다면 추가. 
				continue;
			}
			
			// 현재 사용하고 있는 콘센트 중에 더이상 사용하지 않는 콘센트가 있다면 그거 제거. 
			int maxIdx=0;
			for(int j=0;j<multitap.size();j++) {
				if(dist.get(multitap.get(j))>dist.get(multitap.get(maxIdx))) {
					maxIdx=j;
				}
			}
			multitap.set(maxIdx, use[i]); //콘센트 바꾸기.
			answer++;
			
			//System.out.println(multitap);
			
		}
		System.out.println(answer);
	}
	static int calDist(int find, int back, int[] use) {
		
		for(int i=back+1;i<use.length;i++) {
			if(use[i]==find) {
				return i;
			}
		}
		
		return Integer.MAX_VALUE;
	}
}