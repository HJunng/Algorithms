import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.valueOf(st.nextToken());
        int t=Integer.valueOf(st.nextToken());

        //지점마다 추가되고, 끝나는 사람의 수를 체크
        int[] start=new int[100001];
        int[] end=new int[100001];
        for(int i=1; i<=n; i++) {
            int num = Integer.valueOf(br.readLine());
            for (int j = 1; j <= num; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.valueOf(st.nextToken());
                int e = Integer.valueOf(st.nextToken());

                start[s]++;
                end[e]++;
            }
        }
        //누적합도 진행하면서, 각 구간별로 수가 되고, 줄어든 사람 수를 변화해감.
        long temp=0;
        long[] people=new long[100001];
        for(int i=0; i<=100000; i++){
            people[i]+=temp;
            if(i!=0){
                people[i]+=people[i-1];
            }
            temp+=start[i]; //추가되는 사람의 수
            temp-=end[i]; //감소되는 사람의 수
        }

        //구간별로 구간 중에서 가장 큰 값을 뽑아내기
        int room=t;
        long max=people[t];
        for(int i=t+1; i<=100000; i++){
            long time=people[i]-people[i-t];
            if(time>max){
                max=time;
                room=i;
            }
        }

        bw.write((room-t)+" "+room);
        bw.flush();
    }
}