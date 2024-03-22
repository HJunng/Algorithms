import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String str = s.next();

        char[] directions = str.toCharArray();

        int widthMin, widthMax, lengthMin, lengthMax;
        widthMin = widthMax = lengthMin = lengthMax = 0;

        // 현재 위치, 방향
        int x=0;
        int y=0;
        int dir=0;

        int[] dx = {1,0,-1,0}; // 남, 서, 북, 동 (+1: 오른쪽 회전)
        int[] dy = {0,-1,0,1};

        for(int i=0;i<n;i++){

            switch (directions[i]){
                case 'F':{
                    // 위치 이동
                    x += dx[dir];
                    y += dy[dir];
//                    System.out.println(x+" "+y);

                    // 가로, 세로 시작점 변경
                    lengthMin = Math.min(lengthMin,x);
                    lengthMax = Math.max(lengthMax,x);
                    widthMin = Math.min(widthMin,y);
                    widthMax = Math.max(widthMax,y);

                    break;
                }
                case 'R':{
                    dir = (dir+1)%4; break;
                }
                case 'L':{
                    dir = (dir+3)%4; break;
                }
                default: break;
            }
        }


        char[][] map = new char[lengthMax-lengthMin+1][widthMax-widthMin+1];

        // map의 모든 칸을 #로 초기화
        for(int i=0;i<map.length;i++){
            Arrays.fill(map[i],'#');
        }

        // 현재 위치, 방향
        x = 0-lengthMin;
        y = 0-widthMin;
        dir = 0;

        map[x][y] = '.'; // 현재 위치는 이동할 수 있는 칸으로 .
        for(int i=0;i<n;i++){
            switch (directions[i]){
                case 'F':{
                    //위치 이동
                    x += dx[dir];
                    y += dy[dir];

                    // 이동할 수 있는 칸이므로 . 넣기
                    map[x][y]='.';

                    break;
                }
                case 'R':{
                    dir = (dir+1)%4; break;
                }
                case 'L':{
                    dir = (dir+3)%4; break;
                }
                default: break;
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
}
