package Array;

import java.util.*;
public class Lv2_프렌즈4블록 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        String[] bottom = new String[n]; //바닥부터 시작되는 String 만듦.
        char[][] bottom1 = new char[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bottom1[i][j]=board[m-1-j].charAt(i);
                //System.out.print(bottom1[i][j]);
            }
            //System.out.println();
        }
        //System.out.println();
        
        
        
        while(true){
            //전체 보드를 돌면서 2*2 같은 모양의 블록이 있으면 큐에 넣기.
            Queue<int[]> sameBlock = new LinkedList<>();
            for(int i=0;i+1<n;i++){
                for(int j=0;j+1<bottom1[i].length&&j+1<bottom1[i+1].length;j++){
                
                    if(bottom1[i][j]==bottom1[i+1][j] && bottom1[i][j]==bottom1[i][j+1] && bottom1[i][j]==bottom1[i+1][j+1]){
                        
                        sameBlock.add(new int[]{i,j});
                        sameBlock.add(new int[]{i,j+1});
                        sameBlock.add(new int[]{i+1,j});
                        sameBlock.add(new int[]{i+1,j+1});
                    }
                }
            }
            if(sameBlock.isEmpty()) break; // 같은 블록이 없다면 종료.
            
            
            int[] change;
            while(!sameBlock.isEmpty()){
                change = sameBlock.poll();
                bottom1[change[0]][change[1]]=' '; //같은 블록은 띄어쓰기로 바꿔주기.
            }
            
            for(int i=0;i<n;i++){
                String Trim = (String.valueOf(bottom1[i])).replace(" ","");
                //System.out.println(Trim);
                bottom1[i]=Trim.toCharArray();
            }
        }
        
        for(int i=0;i<n;i++){
            //System.out.println(String.valueOf(bottom1[i]).length());
            answer+=String.valueOf(bottom1[i]).length();
        }
            
        return n*m-answer;
    }
}
