package Math;

public class Lv2_혼자서하는틱택토 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String[] board) {
        int answer = -1;
        
        char[][] b = new char[3][3];
        for(int i=0;i<3;i++) b[i]=board[i].toCharArray();
        
        int cntO=0;
        int cntX=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(b[i][j]=='O') cntO++;
                else if(b[i][j]=='X') cntX++;
            }
        }
        //O랑 X 순서를 잘못 놨을 경우
        if(cntX>cntO || cntO>cntX+1) return 0;
        
        return isCorrect(b,cntO,cntX);
    }
    int isCorrect(char[][] b, int cntO, int cntX){
        int Obingo=0;
        int Xbingo=0;
        
        int rowBingo=0;
        int colBingo=0;
        int diagBingo=0;
        
        //가로에 빙고 몇개인지 확인
        for(int i=0;i<3;i++){
            if(b[i][0]=='.') continue;
            
            if(b[i][0]==b[i][1] && b[i][0]==b[i][2]){
                rowBingo++;
                if(b[i][0]=='O') Obingo++;
                else Xbingo++;
            }
        }
        
        //세로에 빙고가 몇개인지
        for(int i=0;i<3;i++){
            if(b[0][i]=='.') continue;
            
            if(b[0][i]==b[1][i] && b[0][i]==b[2][i]){
                colBingo++;
                if(b[0][i]=='O') Obingo++;
                else Xbingo++;
            }
        }
        
        //대각선 빙고 몇개인지
        if(b[0][0]!='.' && b[0][0]==b[1][1] && b[0][0]==b[2][2]){
            diagBingo++;
            if(b[0][0]=='O') Obingo++;
            else Xbingo++;
        }
        
        if(b[0][2]!='.' && b[0][2]==b[1][1] && b[0][2]==b[2][0]){
            diagBingo++;
            if(b[1][1]=='O') Obingo++;
            else Xbingo++;
        }
        
        if(cntX==4 && cntO==5 && Xbingo>0) return 0;
        
        if(rowBingo>1 || colBingo>1) return 0;
        
        else return 1;
    }
}
