import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,ArrayList<String>> team_member = new HashMap<>();
		Map<String,String> member_team = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String teamName = br.readLine();
			int memberCnt = Integer.parseInt(br.readLine());
			
			team_member.put(teamName, new ArrayList<>());
			
			for(int j=0;j<memberCnt;j++) {
				String member = br.readLine();
				
				team_member.get(teamName).add(member);
				member_team.put(member, teamName);
			}
		}
		
		for(String team : team_member.keySet()) {
			Collections.sort(team_member.get(team));
		}
		
		for(int i=0;i<M;i++) {
			String name = br.readLine();
			int q = Integer.parseInt(br.readLine());
			
			if(q==0) {
				for(String member : team_member.get(name)) {
					System.out.println(member);
				}
			}else if(q==1) {
				System.out.println(member_team.get(name));
			}
		}
 	}
}