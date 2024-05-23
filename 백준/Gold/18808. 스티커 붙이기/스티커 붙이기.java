import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N,M,K;
    static List<int[][]> stickers;
    static int[][] laptop;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        K = Integer.parseInt(s[2]);
        stickers = new ArrayList<>();

        // 주어진 스티커 list에 입력. -> stickers
        for(int k=0;k<K;k++){
            s = br.readLine().split(" ");

            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int[][] sticker = new int[n][m];
            for(int i=0;i<n;i++){
                s = br.readLine().split(" ");
                for(int j=0;j<m;j++){
                    sticker[i][j] = Integer.parseInt(s[j]);
                }
            }
            stickers.add(sticker);
        }

        laptop = new int[N][M];
        for(int k=0;k<K;k++) { // k개의 스티커만큼 스티커 붙이는 방법 반복.
            func(k);
        }

        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(laptop[i][j]==1) cnt++;
            }
        }
        System.out.println(cnt);
    }

    // 스티커를 붙이는 방법 function.
    static void func(int idx){
        int[][] sticker = stickers.get(idx);
        for(int dir=0;dir<4;dir++){
            // 다른 스티커랑 겹치거나 노트븍을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    // 범위 안이고, 다른 스티커랑 겹치지 않으면 붙일 수 있는 거.
                    if(inOfBounds(i,j,sticker.length,sticker[0].length) && possibleAttach(i,j,sticker)){
                        attach(i,j,sticker);
                        return; // 한번 스티커를 붙이면 뗄 일 없음.
                    }
                }
            }

            sticker = rotate(sticker);
        }
    }

    // 노트북 밖으로 스티커가 나가는지 확인.
    static boolean inOfBounds(int x, int y, int rowLen, int colLen){
        if(x+rowLen<=N && y+colLen<=M) return true;
        else return false;
    }

    // 현재 스티커랑 이전에 붙였던 다른 스티커랑 겹치는지 확인
    static boolean possibleAttach(int x, int y, int[][] sticker){
        boolean flag = true;
        for(int i=0;i<sticker.length;i++){
            for(int j=0;j<sticker[0].length;j++){
                if(sticker[i][j]==1 && laptop[x+i][y+j]==1){ // 겹치는지 확인.
                    flag = false; break;
                }
            }
            if(!flag) break;
        }
        return flag;
    }

    // 스티커 붙이기 & 떼기
    static void attach(int x, int y, int[][] sticker){
        // flag:0:떼기  / :1:붙이기
        for(int i=0;i<sticker.length;i++){
            for(int j=0;j<sticker[0].length;j++){
                if(sticker[i][j]==1){
                    laptop[x+i][y+j] = 1; // 붙이거나 떼기.
                }
            }
        }
    }

    // 스티커 회전
    static int[][] rotate(int[][] sticker){
        int n = sticker.length;
        int m = sticker[0].length;

        int[][] rotateSticker = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                rotateSticker[i][j] = sticker[n-j-1][i];
            }
        }
        return rotateSticker;
    }
}