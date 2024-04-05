import java.util.*;
class Solution {
    static int[][] arr;
    static int cnt;
    static int[] dx={1,-1,0,0};//상하좌우 이동
    static int[] dy={0,0,-1,1};
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        arr = new int[maps.length][maps[0].length()];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(maps[i].charAt(j)=='X') arr[i][j]=0;
                else arr[i][j]=maps[i].charAt(j)-'0';
            }
        }
        //cnt세면서 dfs 탐색
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                 if(arr[i][j]>0){
                     cnt=0;
                     dfs(i,j);
                     answerList.add(cnt);
                 }
            }
        }
        
        if(cnt==0) return new int[]{-1};//무인도가 없을 경우
        
        Collections.sort(answerList);//오름차순 정렬
        
        answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++) answer[i]=answerList.get(i);
        
        return answer;
    }
    static void dfs(int x, int y){
        
        cnt+=arr[x][y];
        arr[x][y]=-1;//방문처리
        
        for(int i=0;i<4;i++){
            if(x+dx[i]>=0 && x+dx[i]<arr.length && y+dy[i]>=0 && y+dy[i]<arr[0].length
              && arr[x+dx[i]][y+dy[i]]>0)
                dfs(x+dx[i],y+dy[i]);
        }
    }
}