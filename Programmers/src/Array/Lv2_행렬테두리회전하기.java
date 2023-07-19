package Array;

public class Lv2_행렬테두리회전하기 {
	static int[][] arr;
    static int[] dx={0,1,0,-1};//아래, 오른쪽, 위, 왼쪽
    static int[] dy={-1,0,1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        arr = new int[rows][columns];//1부터 숫자 채워넣기
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=i*columns+j+1;
            }
        }
        
        for(int i=0;i<queries.length;i++){
            //(1,1)부터 시작하기 때문에 queries 1줄여서 arr배열 index에 접근하기 쉽게 바꿈.
            //ex - [2,2,5,4]->[1,1,4,3]
            for(int j=0;j<queries[i].length;j++) queries[i][j]--;
            answer[i]=rotation(queries[i]);
                          
        }
        
        return answer;
    }
    int rotation(int[] q){
        
        int min = arr[q[0]][q[1]];//min값
        int save=arr[q[0]][q[1]];//queries의 첫번째 칸 저장
        
        
        int x=q[0];//행
        int y=q[1];//열
        int dir=0;//방향
        
        while(x!=q[0] || y!=q[1]+1){//시작 (x,y)의 한칸 오른쪽에 도착하면 저장했던 값 입력해야 해서 종료.
            if(x+dx[dir]>=q[0] && x+dx[dir]<=q[2] && y+dy[dir]>=q[1] && y+dy[dir]<=q[3]){
                arr[x][y]=arr[x+dx[dir]][y+dy[dir]];//한칸씩 시계방향으로 이동
                if(arr[x][y]<min) min=arr[x][y];//최솟값 검사
                x+=dx[dir];y+=dy[dir];//위치 이동
                
            }else{//방향 전환
                dir=(dir+1)%4;
            }
        }
        arr[x][y]=save;//저장했던 값 넣어주기.
        
        return min;
    }
}
