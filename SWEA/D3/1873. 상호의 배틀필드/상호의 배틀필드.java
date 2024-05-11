import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    static char[][] map;
    static int[] car;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int w,h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s;
        String str;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            s = br.readLine().split(" ");

            h = Integer.parseInt(s[0]);
            w = Integer.parseInt(s[1]);
            map = new char[h][w];
            car = new int[3];

            for(int i=0;i<h;i++){
                str = br.readLine();
                for(int j=0;j<w;j++){
                    map[i][j] = str.charAt(j);

                    if(map[i][j]=='^'){
                        car[0]=i; car[1]=j;
                        car[2]=0;
                        map[i][j]='.';
                    } else if(map[i][j]=='v'){
                        car[0]=i; car[1]=j;
                        car[2]=1;
                        map[i][j]='.';
                    } else if(map[i][j]=='<'){
                        car[0]=i; car[1]=j;
                        car[2]=2;
                        map[i][j]='.';
                    } else if(map[i][j]=='>'){
                        car[0]=i; car[1]=j;
                        car[2]=3;
                        map[i][j]='.';
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());
            char[] dir = br.readLine().toCharArray();

            move(dir);

            if(car[2]==0){
                map[car[0]][car[1]] = '^';
            } else if(car[2]==1){
                map[car[0]][car[1]] = 'v';
            } else if(car[2]==2){
                map[car[0]][car[1]] = '<';
            } else if(car[2]==3){
                map[car[0]][car[1]] = '>';
            }

            sb.append("#"+t+" ");
            for(int i=0;i<h;i++){
                sb.append(new String(map[i])+"\n");
            }
        }
        System.out.println(sb);
    }
    static void move(char[] dir){
        for(int i=0;i<dir.length;i++){
//            System.out.println(Arrays.toString(car)+" "+dir[i]);
//            for(int j=0;j<h;j++){
//                System.out.println(Arrays.toString(map[j]));
//            }
//            System.out.println();

            switch (dir[i]){
                case 'U':{
                    car[2]=0; // 방향 전환

                    int nx = car[0]+dx[0];
                    int ny = car[1]+dy[0];

                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]=='.'){
                        car[0]=nx; car[1]=ny;
                    }
                    break;
                }
                case 'D':{
                    car[2]=1;

                    int nx = car[0]+dx[1];
                    int ny = car[1]+dy[1];

                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]=='.'){
                        car[0]=nx; car[1]=ny;
                    }
                    break;
                }
                case 'L':{
                    car[2]=2;

                    int nx = car[0]+dx[2];
                    int ny = car[1]+dy[2];

                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]=='.'){
                        car[0]=nx; car[1]=ny;
                    }
                    break;
                }
                case 'R':{
                    car[2]=3;

                    int nx = car[0]+dx[3];
                    int ny = car[1]+dy[3];

                    if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny]=='.'){
                        car[0]=nx; car[1]=ny;
                    }
                    break;
                }
                case 'S':{
                    int nx = car[0];
                    int ny = car[1];

                    while(nx>=0 && nx<h && ny>=0 && ny<w){
//                        System.out.println(nx+" "+ny);
                        if(map[nx][ny]=='.' || map[nx][ny]=='-'){
                            nx+=dx[car[2]];
                            ny+=dy[car[2]];
                        } else if(map[nx][ny]=='*'){
                            map[nx][ny]='.'; break;
                        } else if(map[nx][ny]=='#'){
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
