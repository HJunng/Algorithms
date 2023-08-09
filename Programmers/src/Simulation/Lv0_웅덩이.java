package Simulation;

public class Lv0_웅덩이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println(solution(new int[][]{{10, 20, 50, 30, 20}, {20, 30, 50, 70, 90}, {10, 15, 25, 80, 35}, {25, 35, 40, 55, 80}, {30, 20, 35, 40, 90}}));
		
	}
	static public int solution(int[][] nums) {
		int answer = 0;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		int sum=0;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums[0].length;j++) {
				boolean isPool = true;
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx>=0 && nx<nums.length && ny>=0 && ny<nums[0].length) {
						if(nums[nx][ny]<=nums[i][j]) { isPool=false; break; }
					}
				}
				if(isPool) answer++;
			}
		}
		return answer;
	}
}
