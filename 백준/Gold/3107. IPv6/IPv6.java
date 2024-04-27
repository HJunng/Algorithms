import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipv6 = br.readLine().split(":");

        String[] restore = new String[8];

        int idx=0;
        for(int i=0;i< ipv6.length;i++){
            if(ipv6[i].length()==4){
                // 복원 필요없이 원래 4자리인 경우
                restore[idx++] = ipv6[i];
            } else if(i!=0 && i!=7 && ipv6[i].isEmpty()) {
                // :: 로 사이가 비어있는 경우
                int cnt = 8-ipv6.length+1;
                for(int j=0;j<cnt;j++){
                    restore[idx++] = "0000";
                }
            } else {
                // 네 자리가 아닌 경우
                int cnt = 4-ipv6[i].length();
                restore[idx++] = "0".repeat(cnt) + ipv6[i];
            }
        }

        while(idx < 8){
            restore[idx++] = "0000";
        }

        for(int i=0;i<8;i++){
            System.out.print(restore[i]);
            if(i < 7) System.out.print(":");
        }
    }
}