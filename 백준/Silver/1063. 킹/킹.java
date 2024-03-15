import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String king = s[0];
        String stone = s[1];
        int n = Integer.parseInt(s[2]);

        for(int i=0;i<n;i++){
            String dir = br.readLine();

            String nKing = move(king, dir);

            // king의 위치가 범위를 벗어난다면 그 이동은 건너뜀.
            if(nKing.equals(king)) continue;

            String nStone = stone;

            // 돌의 위치가 이동한 king의 위치와 같다면, stone도 같은 방향으로 이동.
            if(nKing.equals(nStone)){
                nStone = move(nStone, dir);
                // stone의 위치가 범위를 벗어난다면 그 이동은 건너뜀.
                if(nStone.equals(stone)) continue;
            }

            king = nKing;
            stone = nStone;
//            System.out.println(king+" "+stone);
        }

        System.out.println(king+"\n"+stone);
    }
    public static String move(String loc, String dir){

        char col = loc.charAt(0);
        int row = loc.charAt(1)-'0';
        switch (dir){
            case "R":{
                if(col+1 <='H') col +=1;
                break;
            }
            case "L":{
                if(col-1 >='A') col -=1;
                break;
            }
            case "B":{
                if(row-1>=1) row-=1;
                break;
            }
            case "T":{
                if(row+1<=8) row+=1;
                break;
            }
            case "RT":{
                if(col+1<='H' && row+1<=8){
                    col+=1; row+=1;
                }
                break;
            }
            case "LT":{
                if(col-1>='A' && row+1<=8){
                    col-=1; row+=1;
                }
                break;
            }
            case "RB":{
                if(col+1<='H' && row-1>=1){
                    col+=1; row-=1;
                }
                break;
            }
            case "LB":{
                if(col-1>='A' && row-1>=1){
                    col-=1; row-=1;
                }
                break;
            }
            default: break;
        }

        return col+String.valueOf(row);
    }
}