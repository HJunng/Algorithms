class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0;i<balls.length;i++){
            
            int minDist = Integer.MAX_VALUE;
            
            if(balls[i][0]!=startX || balls[i][1]>startY){//위쪽 벽과의 거리
                int topWallDist = (int)(Math.pow(balls[i][0]-startX,2)+Math.pow(balls[i][1]+startY,2));
                if(topWallDist<minDist) minDist=topWallDist;
            }
            if(balls[i][0]!=startX || balls[i][1]<startY){//아래쪽 벽과의 거리
                int bottomWallDist = (int)(Math.pow(balls[i][0]-startX,2)+Math.pow(balls[i][1]-(2*n-startY),2));
                if(bottomWallDist<minDist) minDist=bottomWallDist;
            }
            if(balls[i][0]>startX || balls[i][1]!=startY){//왼쪽 벽과의 거리
                int leftWallDist = (int)(Math.pow(balls[i][0]+startX,2)+Math.pow(balls[i][1]-startY,2));
                if(leftWallDist<minDist) minDist = leftWallDist;
            }
            if(balls[i][0]<startX || balls[i][1]!=startY){//오른쪽 벽과의 거리
                int rightWallDist = (int)(Math.pow(balls[i][0]-(2*m-startX),2)+Math.pow(balls[i][1]-startY,2));
                if(rightWallDist<minDist) minDist=rightWallDist;
            }
            
            answer[i]=minDist;
        }
        
        return answer;
    }
}