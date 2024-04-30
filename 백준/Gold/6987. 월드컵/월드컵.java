import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] worldcup;
    static int[][] match;
    static int MAX_TEAM_COUNT=6;
    static boolean flag;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;

        int tc = 4;

        // 최대 경기 가능한 경우의 수 : 6팀 모두 경기를 하니까 15번의 경기
        int size = 15;

        // 경기 매치 별 팀 별도로 저장
        match = new int[size][2]; // 15번의 경기를 [0] vs [1]
        int idx = 0;
        for(int i=0;i<MAX_TEAM_COUNT;i++){
            for(int j=i+1;j<MAX_TEAM_COUNT;j++){
                match[idx][0] = i;
                match[idx][1] = j;
                idx++;
            }
        }

        while(tc-->0){
            s = br.readLine().split(" ");
            worldcup = new int[MAX_TEAM_COUNT][3]; //승, 무, 패
            boolean isPossible = true;


            // 경기 결과 입력값 받기
            for(int i=0;i<MAX_TEAM_COUNT;i++){
                int win = Integer.parseInt(s[i*3]);
                int draw = Integer.parseInt(s[i*3+1]);
                int lose = Integer.parseInt(s[i*3+2]);

                worldcup[i][0] = win;
                worldcup[i][1] = draw;
                worldcup[i][2] = lose;

                // 한 팀당 5번의 경기를 해야 한다.
                if(win+draw+lose != 5){
                    isPossible = false;
                    break;
                }
            }

            if(isPossible){
                flag = false; // 백트래킹 전에 false로 초기화
                backtracking(0,size);

                if(flag) System.out.print("1 ");
                else System.out.print("0 ");

            } else {
                System.out.print("0 ");
            }
        }
    }
    // 백트래킹
    static void backtracking(int matchCnt, int size){
        if(flag) return; // 찾았으면 더이상 조사 안함.

        // 모든 게임을 수행할 수 있으면 -> 가능한 경기
        if(matchCnt == size){
            flag = true;
            return;
        }

        int myTeam = match[matchCnt][0];
        int enemy = match[matchCnt][1];

        // 승 - 패
        if(worldcup[myTeam][0] > 0 && worldcup[enemy][2] >0){ // 둘의 남은 승, 패 수가 0보다 클 때
            worldcup[myTeam][0]--;
            worldcup[enemy][2]--;
            backtracking(matchCnt+1, size);
            worldcup[myTeam][0]++;
            worldcup[enemy][2]++;
        }

        // 무 - 무
        if(worldcup[myTeam][1] > 0 && worldcup[enemy][1] >0){
            worldcup[myTeam][1]--;
            worldcup[enemy][1]--;
            backtracking(matchCnt+1, size);
            worldcup[myTeam][1]++;
            worldcup[enemy][1]++;
        }

        // 패 - 승
        if(worldcup[myTeam][2] > 0 && worldcup[enemy][0] >0){
            worldcup[myTeam][2]--;
            worldcup[enemy][0]--;
            backtracking(matchCnt+1, size);
            worldcup[myTeam][2]++;
            worldcup[enemy][0]++;
        }
    }
}
