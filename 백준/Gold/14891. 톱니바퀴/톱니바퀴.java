import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] gear = new String[4];
        for(int i=0;i<4;i++) gear[i] = br.readLine();

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String[] s = br.readLine().split(" ");
            int gearNum = Integer.parseInt(s[0])-1; //돌릴 기어 번호
            int dir = Integer.parseInt(s[1]); // 방향: 1(시계), -1(반시계)

            // gearNum의 왼쪽부터 왼쪽 끝까지 다른극인지 확인 후 회전.
            char left = gear[gearNum].charAt(6);
            int iDir = dir;
            for(int i=gearNum-1; i>=0; i--){
                if(gear[i].charAt(2)!=left){ // 다른 극인지 확인
                    left = gear[i].charAt(6); // 톱니바퀴의 맨왼쪽 갱신

                    iDir *= -1;
                    gear[i] = gearRotate(gear[i],iDir);
                }
                else break; // 같은 극이면 거기서 종료.
            }

            // gearNum의 오른쪽끝까지 다른 극인지 확인해 회전.
            char right = gear[gearNum].charAt(2);
            iDir = dir;
            for (int i=gearNum+1; i<4; i++){
                if(gear[i].charAt(6)!=right){ // 다른극인지 확인
                    right = gear[i].charAt(2); //오른쪽 톱니 갱신

                    iDir *= -1;
                    gear[i] = gearRotate(gear[i],iDir);
                }
                else break;
            }

            // 돌리려는 톱니바퀴 회전
            gear[gearNum] = gearRotate(gear[gearNum],dir);
        }

        // 점수계산
        int result=0;
        for(int i=0;i<4;i++){
            if(gear[i].charAt(0)=='1'){
                result += (int)Math.pow(2,i);
            }
        }
        System.out.println(result);
    }
    private static String gearRotate(String gear, int dir){

        if(dir==1){ //시계방향 회전
            gear = gear.charAt(7) + gear.substring(0,7);
        }else{
            gear = gear.substring(1) + gear.charAt(0);
        }
        return gear;
    }
}