import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int ROW = 12;
    static int COL = 6;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[ROW][COL];
        for(int i=0;i<ROW;i++){
            map[i] = br.readLine().toCharArray();
        }

        int cnt=0;
        while(pop()){
            cnt++;
            moveDown();
        }
        System.out.println(cnt);
    }
    static boolean pop(){ // 한번에 모든 색깔 4개 이상씩 있는거 지우기.
        boolean flag = false; // 터트린게 있음.

        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){

                // '.'이 아니면 같은 색깔 4개 이상 모였는지 확인하고 -> 제거.
                if(map[i][j]!='.'){
                    List<int[]> sameColor = cntSameColor(i,j);
                    if(sameColor.size()>=4){
                        flag=true;
                        for(int[] c : sameColor){
                            map[c[0]][c[1]]='.';
                        }
                    }
                }

            }
        }
        return flag;
    }
    static void moveDown(){
        for(int i=0;i<COL;i++){ // , 밑으로 정렬
            Stack<Character> stack = new Stack<>();
            // 각 열마다 위에서부터 뽑아서 stack에 넣고
            for(int j=0;j<ROW;j++){
                if(map[j][i]!='.') {
                    stack.push(map[j][i]);
                    map[j][i]='.';
                }
            }
            // 밑으로 정렬
            for(int j=ROW-1;j>=0;j--){
                if(stack.isEmpty()) break;
                map[j][i] = stack.pop();
            }
        }
    }
    static List<int[]> cntSameColor(int x, int y){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Set<String> set = new HashSet<>();
        set.add(x+" "+y);
        char color = map[x][y];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        List<int[]> result = new ArrayList<>();
        result.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0;i<4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];

                if(nx>=0 && nx<ROW && ny>=0 && ny<COL &&
                        map[nx][ny]==color &&!set.contains(nx+" "+ny)){
                    set.add(nx+" "+ny);
                    q.add(new int[]{nx,ny});
                    result.add(new int[]{nx,ny});
                }
            }
        }
        return result;
    }
}