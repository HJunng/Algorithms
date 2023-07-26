package Array;

public class Lv2_거리두기확인하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0;i<places.length;i++) answer[i]=checkDis(places[i]);
        
        
        return answer;
    }
    //거리두기를 하고 있는지 확인
    static int checkDis(String[] place){
        
        int[] dx={1,-1,0,0};//상하좌우
        int[] dy={0,0,1,-1};
        
        int[] dx2={1,1,-1,-1};//대각선
        int[] dy2={-1,1,-1,1};
        
        for(int x=0;x<5;x++){
            for(int y=0;y<5;y++){
                if(place[x].charAt(y)=='P'){//대기자를 확인하면 주위에 대기자가 있는지 확인
                    //상하좌우에 대기자 있는지 확인
                    for(int dir=0;dir<4;dir++){
                        int nx=x+dx[dir];
                        int ny=y+dy[dir];
                        
                        //거리=1인 상하좌우에 대기자 있는지 확인
                        if(nx>=0 && nx<5 && ny>=0 && ny<5 && place[nx].charAt(ny)=='P')
                            return 0;
                        
                        //상하좌우(거리=1)에 파티션이 없을 때
                        if(nx>=0 && nx<5 && ny>=0 && ny<5 && place[nx].charAt(ny)!='X'){
                            //거리=2인 곳에 대기자 있는지 확인
                            nx+=dx[dir];
                            ny+=dy[dir];
                            
                            if(nx>=0 && nx<5 && ny>=0 && ny<5 && place[nx].charAt(ny)=='P')
                                return 0;
                        }
                    }
                    
                    //대각선에 거리두기 하고 있는지 확인
                    for(int dir=0;dir<4;dir++){
                        int nx=x+dx2[dir];
                        int ny=y+dy2[dir];
                        
                        //대기자 있으면, 파티션이 주위에 있는지 확인
                        if(nx>=0 && nx<5 && ny>=0 && ny<5 && place[nx].charAt(ny)=='P'){
                            if(place[x].charAt(ny)!='X' || place[nx].charAt(y)!='X')
                                return 0;
                        }
                    }
                    
                }
            }
        }
        return 1;//거리두기 잘 됨.
    }
}
