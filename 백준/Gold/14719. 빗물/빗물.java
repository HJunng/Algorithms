import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int w = Integer.parseInt(s[1]);
		int[] blocks = new int[w];
		
		s = br.readLine().split(" ");
		for(int i=0;i<w;i++) blocks[i]=Integer.parseInt(s[i]);
		
		int start=0; //빗물이 고이는 왼쪽 
		int answer=0;
		
		//앞에서부터 커질 때 빗물 담기 
		for(int i=0;i<w;i++) { 
			if(blocks[i]>=blocks[start]) { //i번째 블록이 start 블록보다 크거나 같아지면 -> 빗물이 고임.
				int rainMax = Math.min(blocks[start], blocks[i]);
				for(int j=start+1;j<i;j++) {
					answer+=rainMax-blocks[j]; //빗물 더해주기.
				}
				
				start=i; //빗물 담을 시작위치를 i로 바꿔주기.
			}
		}
		//뒤에서부터 커질 때 빗물 담기 
		start=w-1;
		for(int i=w-1;i>=0;i--) {
			if(blocks[i]>blocks[start]) {
				int rainMax=Math.min(blocks[start], blocks[i]);
				for(int j=start-1;j>i;j--) {
					answer+=rainMax-blocks[j]; //빗물 더해주기 
				}
				
				start=i;
			}
		}
		
		System.out.println(answer);
	}
}